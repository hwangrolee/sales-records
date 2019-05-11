package com.hwangrolee.SalesRecords.lib;

import lombok.Data;

@Data
public class Pageable {
    private int page;
    private int size;

    private Pageable(int page, int size) {
        this.page = page;
        this.size = size;
    }

    static public Pageable of (int page, int size) {
        return new Pageable(page, size);
    }
}
