package com.hwangrolee.SalesRecords.repository;

import com.hwangrolee.SalesRecords.domain.SalesRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class SalesRecordRepository extends ElasticsearchRepository<SalesRecord, Long> {

    @Value("${spring.elasticsearch.index}")
    private String ES_INDEX;

    @Autowired
    public SalesRecordRepository(@Value("${spring.elasticsearch.index}") String INDEX_NAME) {
        super.INDEX_NAME = INDEX_NAME;
    }
}
