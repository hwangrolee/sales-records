package com.hwangrolee.SalesRecords.repository;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.hwangrolee.SalesRecords.domain.AbstractDomain;
import com.hwangrolee.SalesRecords.lib.Page;
import com.hwangrolee.SalesRecords.lib.Pageable;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public abstract class ElasticsearchRepository <T extends AbstractDomain, ID> {

    @Autowired
    private RestHighLevelClient restClient;

    private ObjectMapper om = new ObjectMapper();

    protected String INDEX_NAME = "";

    public Page<T> findAll(Pageable pageable) throws Exception {
        SearchRequest searchRequest = new SearchRequest(INDEX_NAME);
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder
                .query(QueryBuilders.matchAllQuery())
                .size(pageable.getSize())
                .from(pageable.getPage() * pageable.getSize());


        searchRequest.source(searchSourceBuilder);
        SearchResponse searchResponse = restClient.search(searchRequest, RequestOptions.DEFAULT);
        List<T> list = this.getListSearchResult(searchResponse);
        return new Page<T>(list, searchResponse.getHits().totalHits, pageable);
    }

    public void count() {
    }

    public T findOneById(ID id) throws Exception {
        GetRequest getRequest = new GetRequest(INDEX_NAME);
        getRequest.id(id.toString());
        GetResponse getResponse = restClient.get(getRequest, RequestOptions.DEFAULT);
        T item = this.getSingleSearchResult(getResponse);
        return item;
    }

    public T save(T entity) throws Exception {
        IndexRequest indexRequest = new IndexRequest(INDEX_NAME, "_doc", entity.getId().toString());
        indexRequest.source(om.writeValueAsString(entity), XContentType.JSON);
        IndexResponse indexResponse = restClient.index(indexRequest, RequestOptions.DEFAULT);
        if(indexResponse.status() == RestStatus.CREATED || indexResponse.status() == RestStatus.OK) {
            return this.findOneById((ID)indexResponse.getId());
        }
        throw new Exception("데이터를 저장하지 못했습니다.");
    }

    public boolean deleteById(ID id) throws Exception {
        DeleteRequest deleteRequest = new DeleteRequest(INDEX_NAME, "_doc", id.toString());
        DeleteResponse deleteResponse = restClient.delete(deleteRequest, RequestOptions.DEFAULT);
        return RestStatus.OK == deleteResponse.status();
    }

    @SuppressWarnings("unchecked")
    private List<T> getListSearchResult(SearchResponse searchResponse) throws Exception {
        SearchHits searchHits = searchResponse.getHits();
        List list = Arrays
                .stream(searchHits.getHits())
                .map(searchHit -> {
                    return om.convertValue(searchHit.getSourceAsMap(), (Class<T>)this.getClassType()[0]);
                })
                .collect(Collectors.toList());

        return list;
    }

    @SuppressWarnings("unchecked")
    private T getSingleSearchResult(GetResponse getResponse) throws Exception {
        return om.convertValue(getResponse.getSourceAsMap(), (Class<T>)this.getClassType()[0]);
    }

    @SuppressWarnings("unchecked")
    private Class[] getClassType() {
        ParameterizedType parameterizedType = (ParameterizedType)getClass().getGenericSuperclass();
        Type[] types =  parameterizedType.getActualTypeArguments();
        Class[] clazz = { (Class<T>) types[0], (Class<ID>) types[1] };
        return clazz;
    }
}
