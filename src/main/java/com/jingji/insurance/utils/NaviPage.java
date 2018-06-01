package com.jingji.insurance.utils;


import java.io.Serializable;
import java.util.List;

/**
 * 带分页的列表类
 * @author Soar
 * @date 2018/4/21
 */
public class NaviPage<T> implements Serializable {


    private List<T> list;

    private Pager pager;

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Pager getPager() {
        return pager;
    }

    public void setPager(Pager pager) {
        this.pager = pager;
    }
}
