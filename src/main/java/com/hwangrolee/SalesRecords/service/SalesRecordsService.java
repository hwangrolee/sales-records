package com.hwangrolee.SalesRecords.service;

import com.hwangrolee.SalesRecords.domain.SalesRecord;
import com.hwangrolee.SalesRecords.lib.Page;
import com.hwangrolee.SalesRecords.lib.Pageable;
import com.hwangrolee.SalesRecords.lib.SearchParameters;
import com.hwangrolee.SalesRecords.repository.SalesRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalesRecordsService {

    @Autowired
    private SalesRecordRepository salesRecordRepository;

    public Page<SalesRecord> listSalesRecords(SearchParameters searchParameters) throws Exception {
        return salesRecordRepository.findAll(searchParameters, Pageable.of(searchParameters.getPage(), searchParameters.getSize()));
    }

    public long countSalesRecords(SearchParameters searchParameters) throws Exception {
        return salesRecordRepository.count(searchParameters);
    }

    public SalesRecord getSalesRecord(Long orderId) throws Exception {
        return salesRecordRepository.findOneById(orderId);
    }

    public SalesRecord saveSalesRecord(SalesRecord salesRecord) throws Exception {
        return salesRecordRepository.save(salesRecord);
    }

    public boolean deleteSalesRecord(Long orderId) throws Exception {
        return salesRecordRepository.deleteById(orderId);
    }
}
