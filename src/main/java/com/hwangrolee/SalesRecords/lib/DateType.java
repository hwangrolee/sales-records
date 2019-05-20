package com.hwangrolee.SalesRecords.lib;

public enum DateType {
    DATE("yyyy-MM-dd"),
    DATETIME("yyyy-MM-dd HH:mm:ss"),
    TIME("HH:mm:ss")
    ;

    private String format;

    DateType(String format) {
        this.format = format;
    }

    public String getFormat() {
        return format;
    }
}
