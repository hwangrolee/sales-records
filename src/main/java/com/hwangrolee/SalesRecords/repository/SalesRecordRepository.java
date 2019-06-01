package com.hwangrolee.SalesRecords.repository;

import com.hwangrolee.SalesRecords.domain.SalesRecord;
import com.hwangrolee.SalesRecords.lib.Page;
import com.hwangrolee.SalesRecords.lib.Pageable;
import com.hwangrolee.SalesRecords.lib.SearchParameters;
import org.elasticsearch.index.query.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

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

    public long count(SearchParameters searchParameters) throws Exception {
        QueryBuilder queryBuilder = this.createSalesRecordSearchQuery(searchParameters);
        return this.count(queryBuilder);
    }

    private QueryBuilder createSalesRecordSearchQuery(SearchParameters parameters) {

        BoolQueryBuilder query = new BoolQueryBuilder();

        if(parameters.getRegion().size() > 0) {
            query.must(QueryBuilders.termsQuery("region", parameters.getRegion()));
        }

        if(parameters.getCountry().size() > 0) {
            query.must(QueryBuilders.termsQuery("country", parameters.getCountry()));
        }

        if(parameters.getItemType().size() > 0) {
            query.must(QueryBuilders.termsQuery("item_type", parameters.getItemType()));
        }

        if(parameters.getOrderPriority().size() > 0) {
            query.must(QueryBuilders.termsQuery("order_priority", parameters.getOrderPriority()));
        }

        if(StringUtils.isEmpty(parameters.getOrderDate()) == false) {
            query.must(QueryBuilders.termQuery("order_date", parameters.getOrderDate()));
        } else {
            if(StringUtils.isEmpty(parameters.getFromOrderDate()) == false && StringUtils.isEmpty(parameters.getToOrderDate()) == false) {
                query.must(
                        QueryBuilders.rangeQuery("order_date")
                                .from(parameters.getFromOrderDate())
                                .to(parameters.getToOrderDate())
                );
            } else if(StringUtils.isEmpty(parameters.getFromOrderDate()) == false) {
                query.must(
                        QueryBuilders.rangeQuery("order_date")
                                .from(parameters.getFromOrderDate())
                );
            } else if(StringUtils.isEmpty(parameters.getToOrderDate()) == false) {
                query.must(
                        QueryBuilders.rangeQuery("order_date")
                                .to(parameters.getToOrderDate())
                );
            }
        }

        if(StringUtils.isEmpty(parameters.getFromUnitPrice()) == false) {
            RangeQueryBuilder rangeQueryBuilder = new RangeQueryBuilder("unit_price");
            rangeQueryBuilder.from(parameters.getFromUnitPrice());

            if(StringUtils.isEmpty(parameters.getToUnitPrice()) == false) {
                rangeQueryBuilder.to(parameters.getToUnitPrice());
            }

            query.must(rangeQueryBuilder);
        }

        if(StringUtils.isEmpty(parameters.getFromUnitCost()) == false) {
            RangeQueryBuilder rangeQueryBuilder = new RangeQueryBuilder("from_unit_cost");
            rangeQueryBuilder.from(parameters.getFromUnitCost());

            if(StringUtils.isEmpty(parameters.getToUnitCost()) == false) {
                rangeQueryBuilder.to(parameters.getToUnitCost());
            }

            query.must(rangeQueryBuilder);
        }

        if(StringUtils.isEmpty(parameters.getFromTotalRevenue()) == false) {
            RangeQueryBuilder rangeQueryBuilder = new RangeQueryBuilder("from_total_revenue");
            rangeQueryBuilder.from(parameters.getFromTotalRevenue());

            if(StringUtils.isEmpty(parameters.getToTotalRevenue()) == false) {
                rangeQueryBuilder.to(parameters.getToTotalRevenue());
            }

            query.must(rangeQueryBuilder);
        }

        if(StringUtils.isEmpty(parameters.getFromTotalCost()) == false) {
            RangeQueryBuilder rangeQueryBuilder = new RangeQueryBuilder("from_total_cost");
            rangeQueryBuilder.from(parameters.getFromTotalCost());

            if(StringUtils.isEmpty(parameters.getToTotalCost()) == false) {
                rangeQueryBuilder.to(parameters.getToTotalCost());
            }

            query.must(rangeQueryBuilder);
        }

        if(StringUtils.isEmpty(parameters.getFromTotalProfit()) == false) {
            RangeQueryBuilder rangeQueryBuilder = new RangeQueryBuilder("from_total_profit");
            rangeQueryBuilder.from(parameters.getFromTotalProfit());

            if(StringUtils.isEmpty(parameters.getToTotalProfit()) == false) {
                rangeQueryBuilder.to(parameters.getToTotalProfit());
            }

            query.must(rangeQueryBuilder);
        }

        return query;
    }
}
