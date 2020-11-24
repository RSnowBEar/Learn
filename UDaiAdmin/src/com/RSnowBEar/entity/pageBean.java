package com.RSnowBEar.entity;

import java.util.List;

public class pageBean<T> {
    private Integer currentPage;//当前页
    private Integer totalPage;//总页数
    private Integer totalSize;//总的数据量
    private Integer rows=10;//每页显示的数据量
    private List<T> list;//每页显示的数据

    @Override
    public String toString() {
        return "pageBean{" +
                "currentPage=" + currentPage +
                ", totalPage=" + totalPage +
                ", totalSize=" + totalSize +
                ", rows=" + rows +
                ", list=" + list.toString() +
                '}';
    }

    public pageBean() {}

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getTotalPage() {
        return totalSize%rows==0?totalSize/rows:totalSize/rows+1;
    }

    public Integer getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(Integer totalSize) {
        this.totalSize = totalSize;
        this.totalPage = getTotalPage();
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
