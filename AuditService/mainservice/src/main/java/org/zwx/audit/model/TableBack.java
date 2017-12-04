package org.zwx.audit.model;

public class TableBack {
    private String tableName;

    private QueryCondition queryCondition;

    private String fileName;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public QueryCondition getQueryCondition() {
        return queryCondition;
    }

    public void setQueryCondition(QueryCondition queryCondition) {
        this.queryCondition = queryCondition;
    }

    public String getTableName() {

        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
}
