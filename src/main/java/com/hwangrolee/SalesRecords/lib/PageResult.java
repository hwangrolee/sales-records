package com.hwangrolee.SalesRecords.lib;

import lombok.Data;

@Data
public class PageResult<T> extends Result {

    public PageResult(Object page) {
        this.data = page;
    }
}
