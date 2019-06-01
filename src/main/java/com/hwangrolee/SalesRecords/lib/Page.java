package com.hwangrolee.SalesRecords.lib;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Page<T> {

    private List<T> list = new ArrayList<>();
    private long totalCount = 0L;
    private int count = 0;
    private boolean isPrev = false;
    private boolean isNext = false;
    private int totalPage = 0;
    private int page = 0;
    private int size = 10;

    public Page(List<T> list, long totalCount, Pageable pageable) {
        this.list = list;
        this.count = list.size();
        this.totalCount = totalCount;
        this.page = pageable.getPage();
        this.size = pageable.getSize();


        this.totalPage = (int)( this.totalCount / this.size ) + ( this.totalCount % this.size > 0 ? 1 : 0 );

        if(this.page == 0) {
            this.isPrev = false;
        } else if (this.page < this.totalPage) {
            this.isPrev = true;
        }

        if (this.totalPage > this.page + 1) {
            this.isNext = true;
        }
    }
}
