package com.hwangrolee.SalesRecords.service;

import com.hwangrolee.SalesRecords.domain.SalesRecord;
import com.hwangrolee.SalesRecords.repository.SalesRecordsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class SalesRecordsService {

    @Autowired
    private SalesRecordsRepository salesRecordsRepository;

    public Page<SalesRecord> listSalesRecords() {
        return salesRecordsRepository.findAll(PageRequest.of(0, 10));
    }

    public SalesRecord getSalesRecords(Long orderId) {
        return salesRecordsRepository.findById(orderId).orElse(new SalesRecord());
    }

    public SalesRecord upsertSalesRecord(SalesRecord salesRecord) {
        return salesRecordsRepository.index(salesRecord);
    }

    public boolean deleteSalesRecord(Long orderId) {
        salesRecordsRepository.deleteById(orderId);
        return salesRecordsRepository.existsById(orderId);
    }
}
