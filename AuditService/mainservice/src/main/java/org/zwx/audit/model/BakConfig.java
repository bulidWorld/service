package org.zwx.audit.model;

import org.zwx.audit.enums.BakType;

import java.util.List;

public class BakConfig {

    private String maxSize;

    private String bakInterval;

    private int fullSize;

    private List<String> tableNames;

    private BakType bakType;

    private Double criticalRation;

    private int criticalCount;

    public int getCriticalCount() {
        return criticalCount;
    }

    public void setCriticalCount(int criticalCount) {
        this.criticalCount = criticalCount;
    }

    private int oneMaxSize;

    private String orderCloum;

    public String getOrderCloum() {
        return orderCloum;
    }

    public void setOrderCloum(String orderCloum) {
        this.orderCloum = orderCloum;
    }

    public int getOneMaxSize() {
        return oneMaxSize;
    }

    public void setOneMaxSize(int oneMaxSize) {
        this.oneMaxSize = oneMaxSize;
    }

    public String getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(String maxSize) {
        this.maxSize = maxSize;
    }

    public String getBakInterval() {
        return bakInterval;
    }

    public void setBakInterval(String bakInterval) {
        this.bakInterval = bakInterval;
    }

    public int getFullSize() {
        return fullSize;
    }

    public void setFullSize(int fullSize) {
        this.fullSize = fullSize;
    }

    public List<String> getTableNames() {
        return tableNames;
    }

    public void setTableNames(List<String> tableName) {
        this.tableNames = tableNames;
    }

    public BakType getBakType() {
        return bakType;
    }

    public void setBakType(BakType bakType) {
        this.bakType = bakType;
    }

    public Double getCriticalRation() {
        return criticalRation;
    }

    public void setCriticalRation(Double criticalRation) {
        this.criticalRation = criticalRation;
    }

    public String getFileName() {
        //TODO
        return "";
    }
}
