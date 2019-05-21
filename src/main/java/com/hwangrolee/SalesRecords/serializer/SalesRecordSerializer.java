package com.hwangrolee.SalesRecords.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.hwangrolee.SalesRecords.domain.SalesRecord;

import java.io.IOException;

public class SalesRecordSerializer extends JsonSerializer<SalesRecord> {

    @Override
    public void serialize(SalesRecord value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeStartObject();
        gen.writeNumberField("order_id", value.getOrderId());
        gen.writeStringField("region", value.getRegion());
        gen.writeStringField("item_type", value.getItemType());
        gen.writeStringField("order_priority", value.getOrderPriority());
        gen.writeStringField("order_date", value.getOrderDate().toString());
        gen.writeStringField("ship_date", value.getShipDate().toString());
        gen.writeNumberField("units_sold", value.getUnitsSold());
        gen.writeNumberField("unit_price", value.getUnitPrice());
        gen.writeNumberField("unit_cost", value.getUnitCost());
        gen.writeNumberField("total_revenue", value.getTotalRevenue());
        gen.writeNumberField("total_cost", value.getTotalCost());
        gen.writeNumberField("total_profit", value.getTotalProfit());
        gen.writeEndObject();
    }
}
