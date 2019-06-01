package com.hwangrolee.SalesRecords.controller;

import com.hwangrolee.SalesRecords.domain.SalesRecord;
import com.hwangrolee.SalesRecords.lib.Page;
import com.hwangrolee.SalesRecords.lib.PageResult;
import com.hwangrolee.SalesRecords.lib.SearchParameters;
import com.hwangrolee.SalesRecords.lib.SingleResult;
import com.hwangrolee.SalesRecords.service.SalesRecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/sales-records")
public class SalesRecordsController {

    @Autowired
    private SalesRecordsService salesRecordsService;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = { "application/json" })
    public @ResponseBody ResponseEntity<PageResult> listSalesRecords( SearchParameters searchParameters) throws Exception {
        Page<SalesRecord> listSalesRecords = salesRecordsService.listSalesRecords(searchParameters);
        PageResult pageResult = new PageResult(listSalesRecords);
        return  ResponseEntity.status(HttpStatus.OK).body(pageResult);
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<SingleResult> countSalesRecords(SearchParameters searchParameters) throws Exception {
        long countSalesRecords = salesRecordsService.countSalesRecords(searchParameters);
        SingleResult singleResult = new SingleResult(countSalesRecords);
        return ResponseEntity.status(HttpStatus.OK).body(singleResult);
    }

    @RequestMapping(value = "/{orderId}", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<SingleResult> getSalesRecords(@PathVariable("orderId") Long orderId) throws Exception {
        SalesRecord salesRecord = salesRecordsService.getSalesRecord(orderId);
        if(salesRecord.getOrderId() == 0L) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        SingleResult singleResult = new SingleResult(salesRecord);
        return  ResponseEntity.status(HttpStatus.OK).body(singleResult);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<SingleResult> saveSalesRecord(@RequestBody SalesRecord salesRecord) throws Exception {
        SalesRecord savedSalesRecord = salesRecordsService.saveSalesRecord(salesRecord);
        SingleResult singleResult = new SingleResult(savedSalesRecord);
        return ResponseEntity.status(HttpStatus.OK).body(singleResult);
    }

    @RequestMapping(value = "/{orderId}", method = RequestMethod.PUT)
    public @ResponseBody ResponseEntity<SingleResult> updateSalesRecord(@PathVariable("orderId") Long orderId, @RequestBody SalesRecord salesRecord) throws Exception {
        SalesRecord savedSalesRecord = salesRecordsService.getSalesRecord(orderId);

        if(savedSalesRecord.getOrderId() == 0L) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        salesRecord.setOrderId(orderId);
        savedSalesRecord = salesRecordsService.saveSalesRecord(salesRecord);
        SingleResult singleResult = new SingleResult(savedSalesRecord);
        return ResponseEntity.status(HttpStatus.OK).body(singleResult);
    }

    @RequestMapping(value = "/{orderId}", method = RequestMethod.DELETE)
    public @ResponseBody ResponseEntity<SingleResult> deleteSalesRecord(@PathVariable("orderId") Long orderId) throws Exception {
        SalesRecord savedSalesRecord = salesRecordsService.getSalesRecord(orderId);

        if(savedSalesRecord.getOrderId() == 0L) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        boolean result = salesRecordsService.deleteSalesRecord(orderId);
        SingleResult singleResult = new SingleResult(result);
//        HashMap<String, Object> resultMap = new HashMap<String, Object>(){ { put("result", result); } };
        return ResponseEntity.status(HttpStatus.OK).body(singleResult);
    }

}
