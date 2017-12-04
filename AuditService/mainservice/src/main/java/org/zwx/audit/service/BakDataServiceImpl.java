package org.zwx.audit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.zwx.audit.dao.BakDao;
import org.zwx.audit.model.CommConfg;
import org.zwx.audit.model.TableBack;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BakDataServiceImpl implements BakDatabaseService {

    @Autowired
    private BakDao bakDao;

    @Autowired
    private CsvWriterService csvWriterService;

    @Override
    public void bak(TableBack tableBack) {

        Map<String, Object> map = new HashMap<>();
        map.put("tableName", tableBack.getTableName());
        List<String> columns = bakDao.getColumns(map);
        List<Map<String, Object>> rs = bakDao.getResultLst(tableBack.getQueryCondition());
        Path path = Paths.get(CommConfg.BAK_PATH);
        Path filePath = path.resolve(tableBack.getFileName());
        csvWriterService.write2Csv(filePath, columns, rs);
        //bak success delete baked data
        bakDao.delete(tableBack.getQueryCondition());
    }

}
