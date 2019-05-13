package com.hwangrolee.SalesRecords.domain;

import lombok.Data;

import java.util.Date;

@Data
public class SalesRecord extends AbstractDomain<Long>{

    private Long orderId = 0L;
    private String region;
    private String country;
    private String itemType;
    private String salesChannel;
    private String orderPriority;
    private Date orderDate = new Date();
    private Date shipDate;
    private Integer unitsSold;
    private Float unitPrice;
    private Float unitCost;
    private Float totalRevenue;
    private Float totalCost;
    private Float totalProfit;
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
        super.setId(orderId);
    }

}
