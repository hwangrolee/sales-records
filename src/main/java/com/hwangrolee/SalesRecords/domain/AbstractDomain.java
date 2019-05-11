package com.hwangrolee.SalesRecords.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public abstract class AbstractDomain<ID> {

    @JsonIgnore
    private ID id;
}
