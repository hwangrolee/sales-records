package com.hwangrolee.SalesRecords.lib;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 검색을 위한 파라미터 객체
 * 파라미터를 Controller에 Binding할때 config/resolver/SearchParameterResolver.class를 참조하여 binding을 한다.
 * @see com.hwangrolee.SalesRecords.config.resolver.SearchParameterResolver
 * @author hwangrolee
 * @version 1.0
 */
@Data
public class SearchParameters extends AbstractSearchParameter {

    private List<String> country = new ArrayList<String>();
    private List<String> region = new ArrayList<String>();
    private List<String> itemType = new ArrayList<String>();
    private List<String> orderPriority = new ArrayList<String>();
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
