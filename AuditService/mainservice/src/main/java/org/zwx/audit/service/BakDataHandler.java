package org.zwx.audit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.zwx.audit.dao.BakDao;
import org.zwx.audit.model.BakConfig;
import org.zwx.audit.model.QueryCondition;
import org.zwx.audit.model.TableBack;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class BakDataHandler {

    private static final Long DEFAULT_FROM = 0L;

    @Autowired
    private BakDao bakDao;

    @Autowired
    private BakDatabaseService bakDatabaseService;

    private ThreadLocal<BakConfig> localBakConfig;

    public BakDataHandler(BakConfig localBakConfig) {
        this.localBakConfig.set(localBakConfig);
    }

    private boolean checkNeedBak(String tableName){
        switch (localBakConfig.get().getBakType()) {
            case PERIOD:
                return isPeriodDay();
            case COUNT:
                return isCountOver(tableName);
            case OVERRATION:
                return isRationOver();
            default:
                return false;
        }
    }

    private boolean isCountOver(String tableName) {

//        return bakDao.getTableCount(tableName) > localBakConfig.get().getCriticalCount();
        return true;
    }


    private void doBak() {
        getTableBacks(localBakConfig.get()).forEach(tableBack -> bakDatabaseService.bak(tableBack));
    }


    public Set<TableBack> getTableBacks(BakConfig bakConfig) {
        Set<TableBack> set = bakConfig.getTableNames().stream()
                .map(tableName ->{
                    TableBack tableBack = new TableBack();
                    tableBack.setTableName(tableName);
                    tableBack.setFileName(bakConfig.getFileName());
                    tableBack.setQueryCondition(getQueryCondition(tableName));

                    return tableBack;
                }).collect(Collectors.toSet());
        return set;
    }

    //TODO lack logic
    private boolean isRationOver() {
        return false;
    }

    private Long getTableCount(String tableName) {
//        return bakDao.getTableCount(tableName);
        return 0L;
    }

    public boolean isPeriodDay() {
        return false;
    }

    private QueryCondition getQueryCondition(String tableName) {
        QueryCondition queryCondition = new QueryCondition();
        queryCondition.setOrderColumn(localBakConfig.get().getOrderCloum());

        int oneMaxSize = localBakConfig.get().getOneMaxSize();
        Long tableCount = getTableCount(tableName);
        Long exproedSize = 0L;
        exproedSize = Math.min(oneMaxSize, tableCount);
        queryCondition.setFrom(DEFAULT_FROM);
        queryCondition.setTo(exproedSize);
        return queryCondition;
    }


}
