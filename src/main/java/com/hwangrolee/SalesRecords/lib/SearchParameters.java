package com.hwangrolee.SalesRecords.lib;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import org.springframework.boot.jackson.JsonComponent;

import java.io.Serializable;
import java.util.Date;

@Data
public class SearchParameters extends AbstractSearchParameter {

    private String[] country = new String[]{};
    private String[] region = new String[]{};
    @JsonProperty(value = "item_type", access = JsonProperty.Access.READ_WRITE)
    private String[] itemType = new String[]{};
    private String[] orderPriority = new String[]{};
    private String orderDate;
    private String shipDate;

    private String fromOrderDate;
    private String fromOrderTime;
    private String toOrderDate;
    private String toOrderTime;

    private String fromShipDate;
    private String fromShipTime;
    private String toShipDate;
    private String toShipTime;

    private Integer fromUnitsSold;
    private Integer toUnitsSold;

    private Float fromUnitPrice;
    private Float toUnitPrice;

    private Float fromUnitCode;
    private Float toUnitCode;

    private Float fromTotalRevenue;
    private Float toTotalRevenue;

    private Float fromTotalCost;
    private Float toTotalCost;

    private Float fromTotalProfit;
    private Float toTotalProfit;

    private String location;
    private long timestamp = new Date().getTime();
}
