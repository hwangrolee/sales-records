package com.hwangrolee.SalesRecords.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class SalesRecord extends AbstractDomain{
        private Long id = 0L;
//    @JsonProperty(value = "order_id")
    protected Long orderId = 0L;

//    @JsonProperty("region")
protected String region;

//    @JsonProperty("country")
protected String country;

//    @JsonProperty("item_type")
    private String itemType;

//    @JsonProperty("sales_channel")
    private String salesChannel;

//    @JsonProperty("order_priority")
    private String orderPriority;

//    @JsonProperty("order_date")
    private Date orderDate;

//    @JsonProperty("ship_date")
    private Date shipDate;

//    @JsonProperty("units_sold")
    private Integer unitsSold;

//    @JsonProperty("unit_price")
    private Float unitPrice;

//    @JsonProperty("unit_cost")
    private Float unitCost;

//    @JsonProperty("total_revenue")
    private Float totalRevenue;

//    @JsonProperty("total_cost")
    private Float totalCost;

//    @JsonProperty("total_profit")
    private Float totalProfit;
}
