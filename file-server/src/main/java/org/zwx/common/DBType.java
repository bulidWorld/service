package org.zwx.common;

public enum  DBType {


    REDIS("redis"),

    MYSQL("mysql");



    public String value;

    private DBType(String type)
    {
        this.value = type;
    }
}
