package com.laptrinhjavaweb.pagingandsorting;

public class PagingAndSorting {

    private Integer page;

    private Integer limit;

    private String sortBy;

    private String sortName;

    public PagingAndSorting() {

    }

    public PagingAndSorting(Integer page, Integer limit, String sortBy, String sortName) {
        this.page = page;
        this.limit = limit;
        this.sortBy = sortBy;
        this.sortName = sortName;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }

    public boolean checkNull(){
        if(this.limit != null || this.page != null || this.sortBy != null || this.sortName != null){
            return false;
        }
        return true;
    }
}
