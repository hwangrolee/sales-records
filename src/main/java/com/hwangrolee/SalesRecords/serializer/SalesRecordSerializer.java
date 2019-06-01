package com.hwangrolee.SalesRecords.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.hwangrolee.SalesRecords.domain.SalesRecord;
import org.springframework.util.StringUtils;

import java.io.IOException;

public class SalesRecordSerializer extends JsonSerializer<SalesRecord> {

    @Override
    public void serialize(SalesRecord value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeStartObject();
        gen.writeNumberField("order_id", value.getOrderId());

        if(StringUtils.isEmpty(value.getRegion()) == false) {
            gen.writeStringField("region", value.getRegion());
        }

        if(StringUtils.isEmpty(value.getItemType()) == false) {
            gen.writeStringField("item_type", value.getItemType());
        }

        if(StringUtils.isEmpty(value.getOrderPriority()) == false) {
            gen.writeStringField("order_priority", value.getOrderPriority());
        }

        if(StringUtils.isEmpty(value.getOrderDate()) == false) {
            gen.writeNumberField("order_date", value.getOrderDate().getTime());
        }

        if(StringUtils.isEmpty(value.getShipDate()) == false) {
            gen.writeNumberField("ship_date", value.getShipDate().getTime());
        }

        if(StringUtils.isEmpty(value.getUnitsSold()) == false) {
            gen.writeNumberField("units_sold", value.getUnitsSold());
        }

        if(StringUtils.isEmpty(value.getUnitPrice()) == false) {
            gen.writeNumberField("unit_price", value.getUnitPrice());
        }

        if(StringUtils.isEmpty(value.getUnitCost()) == false) {
            gen.writeNumberField("unit_cost", value.getUnitCost());
        }

        if(StringUtils.isEmpty(value.getTotalRevenue()) == false) {
            gen.writeNumberField("total_revenue", value.getTotalRevenue());
        }

        if(StringUtils.isEmpty(value.getTotalCost()) == false) {
            gen.writeNumberField("total_cost", value.getTotalCost());
        }

        if(StringUtils.isEmpty(value.getTotalProfit()) == false) {
            gen.writeNumberField("total_profit", value.getTotalProfit());
        }

        gen.writeEndObject();
    }
}
