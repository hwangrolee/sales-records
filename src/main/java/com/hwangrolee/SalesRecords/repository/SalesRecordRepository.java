package com.hwangrolee.SalesRecords.repository;

import com.hwangrolee.SalesRecords.domain.SalesRecord;
import com.hwangrolee.SalesRecords.lib.Page;
import com.hwangrolee.SalesRecords.lib.Pageable;
import com.hwangrolee.SalesRecords.lib.SearchParameters;
import org.elasticsearch.index.query.*;
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

    public Page<SalesRecord> findAll(SearchParameters searchParameters, Pageable pageable) throws Exception {
        QueryBuilder queryBuilder = this.createSalesRecordSearchQuery(searchParameters);
        return this.findAll(queryBuilder, pageable);
    }

    private QueryBuilder createSalesRecordSearchQuery(SearchParameters parameters) {

        BoolQueryBuilder query = new BoolQueryBuilder();

        if(parameters.getRegion().length > 0) {
            query.must(QueryBuilders.termsQuery("region", parameters.getRegion()));
        }

        if(parameters.getCountry().length > 0) {
            query.must(QueryBuilders.termsQuery("country", parameters.getCountry()));
        }

        if(parameters.getItemType().length > 0) {
            query.must(QueryBuilders.termsQuery("item_type", parameters.getItemType()));
        }

        if(parameters.getOrderPriority().length > 0) {
            query.must(QueryBuilders.termsQuery("order_priority", parameters.getOrderPriority()));
        }

        return query;
    }
}
