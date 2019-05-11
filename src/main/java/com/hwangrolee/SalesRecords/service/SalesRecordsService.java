package com.hwangrolee.SalesRecords.service;

import com.hwangrolee.SalesRecords.domain.SalesRecord;
import com.hwangrolee.SalesRecords.lib.Page;
import com.hwangrolee.SalesRecords.lib.Pageable;
import com.hwangrolee.SalesRecords.repository.SalesRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalesRecordsService {

    @Autowired
    private SalesRecordRepository salesRecordRepository;

    public Page<SalesRecord> listSalesRecords() throws Exception {
        return salesRecordRepository.findAll(Pageable.of(0, 10));
    }

    public SalesRecord getSalesRecord(Long orderId) throws Exception {
        return (SalesRecord) salesRecordRepository.findOneById(orderId);
    }

}
