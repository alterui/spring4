package com.oyo.spring4.demo1008;

import java.io.Serializable;
import java.util.List;

/**
 * @author liurui
 * @date 2019/10/8 10:34
 */
public class PagedResponse<T> implements Serializable {
    private Integer pageNum;
    private Integer pageSize;
    private Long totalPages;
    private Long totalCount;
    private List<T> result;

    public PagedResponse() {
    }

    public PagedResponse(Integer pageNum, Integer pageSize, Long totalCount) {
//        this.pageNum = pageNum;
//        this.pageSize = pageSize;
//        this.totalCount = totalCount;
        this.setPageNum(pageNum);
        this.setPageSize(pageSize);
        this.setTotalCount(totalCount);

    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        System.out.println("setPageNum");
        this.pageNum = pageNum;
        if (pageNum < 1) {
            this.pageNum = 1;
        } else if ((long) pageNum > this.getTotalPages()) {
            this.pageNum = this.getTotalPages().intValue();
        }
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Long getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Long totalPages) {
        this.totalPages = totalPages;
    }

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
        long result = totalCount / (long) this.getPageSize();
        if (totalCount % (long) this.pageSize != 0L) {
            result = result + 1L;
        }
        this.setTotalPages(result);
    }

    public List<T> getResult() {
        return result;
    }

    public void setResult(List<T> result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "PagedResponse{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", totalPages=" + totalPages +
                ", totalCount=" + totalCount +
                ", result=" + result +
                '}';
    }

    public void get() {
        PagedResponse pagedResponse = new PagedResponse(-1, -1, -1L);
        // pagedResponse.setPageNum(-1);

        System.out.println(pagedResponse);
    }
}