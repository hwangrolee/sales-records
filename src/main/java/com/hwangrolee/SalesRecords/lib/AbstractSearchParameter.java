package com.hwangrolee.SalesRecords.lib;

import lombok.Data;

@Data
public abstract class AbstractSearchParameter {
    private int size = 10;
    private int page = 0;
    private String sort = "";
}
