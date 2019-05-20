package com.hwangrolee.SalesRecords.lib;

import lombok.Data;

@Data
public abstract class AbstractSearchParameter {
    protected int size = 10;
    protected int page = 0;
    protected String sort = "";
}
