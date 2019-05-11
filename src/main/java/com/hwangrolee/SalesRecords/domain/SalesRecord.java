package com.hwangrolee.SalesRecords.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.*;

import java.util.Date;

@Document(indexName = "sales-records", type = "_doc", createIndex = false)
@Data
public class SalesRecord {

    @Id
    private Long id = 0L;

    @Field(type = FieldType.Long)
    @Mapping(mappingPath = "order_id")
    @JsonProperty(value = "order_id", access = JsonProperty.Access.READ_WRITE)
    private Long orderId = 0L;

//    @Field(type = FieldType.Text)
    @JsonProperty("region")
    private String region;

    @Field(type = FieldType.Text)
    @JsonProperty("country")
    private String country;

    @Field(type = FieldType.Text)
    @JsonProperty("item_type")
    @Mapping(mappingPath = "item_type")
    private String itemType;

    @Field(type = FieldType.Text)
    @JsonProperty("sales_channel")
    private String salesChannel;

    @Field(type = FieldType.Text)
    @JsonProperty("order_priority")
    private String orderPriority;

    @Field(type = FieldType.Date, format = DateFormat.date_optional_time)
    @JsonProperty("order_date")
    private Date orderDate;

    @Field(type = FieldType.Date, format = DateFormat.date_optional_time)
    @JsonProperty("ship_date")
    private Date shipDate;

    @Field(type = FieldType.Integer)
    @JsonProperty("units_sold")
    private Integer unitsSold;

    @Field(type = FieldType.Float)
    @JsonProperty("unit_price")
    private Float unitPrice;

    @Field(type = FieldType.Float)
    @JsonProperty("unit_cost")
    private Float unitCost;

    @Field(type = FieldType.Float)
    @JsonProperty("total_revenue")
    private Float totalRevenue;

    @Field(type = FieldType.Float)
    @JsonProperty("total_cost")
    private Float totalCost;

    @Field(type = FieldType.Float)
    @JsonProperty("total_profit")
    private Float totalProfit;

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
        this.id = orderId;
    }
}
