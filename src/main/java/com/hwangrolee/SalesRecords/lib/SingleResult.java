package com.hwangrolee.SalesRecords.lib;

import lombok.Data;

@Data
public class SingleResult extends Result {
    public SingleResult(Object data) {
        this.data = data;
    }
}
