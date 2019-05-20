package com.hwangrolee.SalesRecords.controller;

import com.hwangrolee.SalesRecords.domain.SalesRecord;
import com.hwangrolee.SalesRecords.lib.Page;
import com.hwangrolee.SalesRecords.lib.SearchParameters;
import com.hwangrolee.SalesRecords.service.SalesRecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/sales-records")
public class SalesRecordsController {

    @Autowired
    private SalesRecordsService salesRecordsService;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = { "application/json" })
    public @ResponseBody ResponseEntity<Page<SalesRecord>> listSalesRecords( SearchParameters searchParameters) throws Exception {
        Page<SalesRecord> listSalesRecords = salesRecordsService.listSalesRecords(searchParameters);
        return  ResponseEntity.status(HttpStatus.OK).body(listSalesRecords);
    }

    @RequestMapping(value = "/{orderId}", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<SalesRecord> getSalesRecords(@PathVariable("orderId") Long orderId) throws Exception {
        SalesRecord salesRecord = salesRecordsService.getSalesRecord(orderId);

        if(salesRecord.getOrderId() == 0L) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        return  ResponseEntity.status(HttpStatus.OK).body(salesRecord);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<SalesRecord> saveSalesRecord(@RequestBody SalesRecord salesRecord) throws Exception {
        SalesRecord savedSalesRecord = salesRecordsService.saveSalesRecord(salesRecord);
        return ResponseEntity.status(HttpStatus.OK).body(savedSalesRecord);
    }

    @RequestMapping(value = "/{orderId}", method = RequestMethod.PUT)
    public @ResponseBody ResponseEntity<SalesRecord> updateSalesRecord(@PathVariable("orderId") Long orderId, @RequestBody SalesRecord salesRecord) throws Exception {
        SalesRecord savedSalesRecord = salesRecordsService.getSalesRecord(orderId);

        if(savedSalesRecord.getOrderId() == 0L) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        salesRecord.setOrderId(orderId);
        savedSalesRecord = salesRecordsService.saveSalesRecord(salesRecord);
        return ResponseEntity.status(HttpStatus.OK).body(savedSalesRecord);
    }

    @RequestMapping(value = "/{orderId}", method = RequestMethod.DELETE)
    public @ResponseBody ResponseEntity<Map> deleteSalesRecord(@PathVariable("orderId") Long orderId) throws Exception {
        SalesRecord savedSalesRecord = salesRecordsService.getSalesRecord(orderId);

        if(savedSalesRecord.getOrderId() == 0L) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        boolean result = salesRecordsService.deleteSalesRecord(orderId);
        HashMap<String, Object> resultMap = new HashMap<String, Object>(){ { put("result", result); } };
        return ResponseEntity.status(HttpStatus.OK).body(resultMap);
    }

}
