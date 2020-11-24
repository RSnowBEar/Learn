package hy.domain;

import java.util.List;

public class PageBean<T> {
    private Integer currentPage;//当前页
    private Integer totalPage;//总页数
    private Integer totalSize;//总的数据量
    private Integer rows=5;//每页显示的数据量
    private List<T> list;//每页显示的数据


    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getTotalPage() {
        if(totalSize%rows==0){
            totalPage = totalSize/rows;
        }else{
            totalPage = totalSize/rows+1;
        }
        return totalPage;
    }

    public Integer getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(Integer totalSize) {
        this.totalSize = totalSize;
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
