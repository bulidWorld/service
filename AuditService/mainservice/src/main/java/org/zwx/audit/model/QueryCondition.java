package org.zwx.audit.model;

public class QueryCondition {

    private String orderColumn;

    private Long from;

    private Long to;

    private String tableName;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public QueryCondition() {

    }

    public QueryCondition(String orderColumn, Long from, Long to) {
        this.orderColumn = orderColumn;
        this.from = from;
        this.to = to;
    }

    public String getOrderColumn() {
        return orderColumn;
    }

    public void setOrderColumn(String orderColumn) {
        this.orderColumn = orderColumn;
    }

    public Long getFrom() {
        return from;
    }

    public void setFrom(Long from) {
        this.from = from;
    }

    public Long getTo() {
        return to;
    }

    public void setTo(Long to) {
        this.to = to;
    }
}
