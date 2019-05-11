package com.hwangrolee.SalesRecords.controller;

import com.hwangrolee.SalesRecords.domain.SalesRecord;
import com.hwangrolee.SalesRecords.lib.Page;
import com.hwangrolee.SalesRecords.service.SalesRecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/sales-records")
public class SalesRecordsController {

    @Autowired
    private SalesRecordsService salesRecordsService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<Page<SalesRecord>> listSalesRecords() throws Exception {
        Page<SalesRecord> listSalesRecords = salesRecordsService.listSalesRecords();
        return  ResponseEntity.status(HttpStatus.OK).body(listSalesRecords);
    }

    @RequestMapping(value = "/{orderId}", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<SalesRecord> getSalesRecords(@PathVariable("orderId") Long orderId) throws Exception {
        SalesRecord salesRecord = salesRecordsService.getSalesRecord(orderId);

//        if(salesRecord.getOrderId() == 0L) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//        }

        return  ResponseEntity.status(HttpStatus.OK).body(salesRecord);
    }
//
//    @RequestMapping(value = "", method = RequestMethod.POST)
//    public @ResponseBody ResponseEntity<SalesRecord> saveSalesRecord(@RequestBody SalesRecord salesRecord) {
//
////        salesRecord.setOrderId(1L);
//        salesRecord.setRegion("Asia");
//        salesRecord.setCountry("South Korea");
//        salesRecord.setItemType("Fruits");
//        salesRecord.setSalesChannel("Offline");
//        salesRecord.setOrderPriority("M");
//        salesRecord.setOrderDate(new Date());
//        salesRecord.setShipDate(new Date());
//        salesRecord.setUnitsSold(1111);
//        salesRecord.setUnitPrice(2222.22F);
//        salesRecord.setUnitCost(3333.33F);
//        salesRecord.setTotalRevenue(4444.44F);
//        salesRecord.setTotalCost(555.55F);
//        salesRecord.setTotalProfit(666.66F);
//
//        SalesRecord savedSalesRecord = salesRecordsService.upsertSalesRecord(salesRecord);
//        return ResponseEntity.status(HttpStatus.OK).body(savedSalesRecord);
//    }
//
//    @RequestMapping(value = "/{orderId}", method = RequestMethod.PUT)
//    public @ResponseBody ResponseEntity<SalesRecord> updateSalesRecord(@PathVariable("orderId") Long orderId, @RequestBody SalesRecord salesRecord) {
//        SalesRecord savedSalesRecord = salesRecordsService.getSalesRecords(orderId);
//
//        if(savedSalesRecord.getOrderId() == 0L) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//        }
//
//        salesRecord.setOrderId(orderId);
//        savedSalesRecord = salesRecordsService.upsertSalesRecord(salesRecord);
//        return ResponseEntity.status(HttpStatus.OK).body(savedSalesRecord);
//    }
//
//    @RequestMapping(value = "/{orderId}", method = RequestMethod.DELETE)
//    public @ResponseBody ResponseEntity<Boolean> deleteSalesRecord(@PathVariable("orderId") Long orderId) {
//        SalesRecord savedSalesRecord = salesRecordsService.getSalesRecords(orderId);
//
//        if(savedSalesRecord.getOrderId() == 0L) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//        }
//
//        boolean existSalesRecord = salesRecordsService.deleteSalesRecord(orderId);
//        return ResponseEntity.status(HttpStatus.OK).body(existSalesRecord);
//    }

}
