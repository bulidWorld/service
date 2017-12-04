package org.zwx.audit.enums;

public enum BakType {

    OVERRATION(1),
    PERIOD(2),
    COUNT(3);

    private int value;


    private BakType(int value) {
        this.value = value;
    }
}
