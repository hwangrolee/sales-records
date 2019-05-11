package com.hwangrolee.SalesRecords.repository;

import com.hwangrolee.SalesRecords.domain.SalesRecord;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesRecordsRepository extends ElasticsearchRepository<SalesRecord, Long> {

}
