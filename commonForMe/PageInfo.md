### about  com.github.pagehelper.PageInfo 重写

~~~java
package com.SunAd.document.common;

import java.util.List;

/**
 * 简化分页信息
 *
 * @author sunyang
 * @date 2018/10/22 18:28
 */
public class PageInfo<T>{

    private static final long serialVersionUID = 1L;

    private int pageNum;
    private int pageSize;

    private List<T> pageList;

    public PageInfo() {
    }

    public PageInfo(List<T> list) {
        com.github.pagehelper.PageInfo<T> pageInfo = new com.github.pagehelper.PageInfo<T>(list);
        this.pageNum = pageInfo.getPageNum();
        this.pageSize = pageInfo.getPageSize();
        this.pageList = pageInfo.getList();
    }

    public PageInfo(int pageNum, int pageSize, List<T> pageList) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.pageList = pageList;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getPageList() {
        return pageList;
    }

    public void setPageList(List<T> pageList) {
        this.pageList = pageList;
    }

    @Override
    public String toString() {
        return "PageInfo{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", pageList=" + pageList +
                '}';
    }

}
~~~

