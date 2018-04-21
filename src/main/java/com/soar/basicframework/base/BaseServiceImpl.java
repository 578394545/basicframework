package com.soar.basicframework.base;

import java.io.Serializable;
import java.util.List;

import com.soar.basicframework.utils.NaviPage;
import com.soar.basicframework.utils.OrderByDto;
import com.soar.basicframework.utils.Pager;
import org.springframework.transaction.annotation.Transactional;

/**
 * service抽象类，实现部分公共方法
 *
 * @author Soar
 * @date 2018/4/21
 */
public abstract class BaseServiceImpl<T> implements BaseService<T> {
    /**
     * 抽象方法，必须实现，返回DAO实例
     *
     * @return DAO实例
     */
    public abstract BaseDao<T> getDao();

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insert(T t) {
        return getDao().insert(t);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void insertList(List<T> list) {
        getDao().insertList(list);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public NaviPage<T> getNaviPage(T t, Pager pager) {
        NaviPage<T> naviPage = new NaviPage<T>();
        naviPage.setList(getDao().getNaviPage(t, pager));
        naviPage.setPager(pager);
        return naviPage;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(Serializable id) {
        getDao().delete(id);
    }

    @Transactional(readOnly = true,rollbackFor = Exception.class)
    @Override
    public int getTotal(T t) {
        return getDao().getTotal(t);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void update(T t) {
        getDao().update(t);
    }

    @Transactional(readOnly = true,rollbackFor = Exception.class)
    @Override
    public List<T> getAll() {
        return getDao().getAll();
    }

    @Transactional(readOnly = true,rollbackFor = Exception.class)
    @Override
    public List<T> getList(T t) {
        return getDao().getList(t);
    }

    @Transactional(readOnly = true,rollbackFor = Exception.class)
    @Override
    public T get(Serializable id) {
        return getDao().get(id);
    }

    @Transactional(readOnly = true,rollbackFor = Exception.class)
    @Override
    public List<T> getPage(T t, Pager pager) {
        return getDao().getPage(t, null, pager);
    }

    @Transactional(readOnly = true,rollbackFor = Exception.class)
    @Override

    public List<T> getPage(T t, OrderByDto orderBy, Pager pager) {
        return getDao().getPage(t, orderBy, pager);
    }

    @Transactional(readOnly = true,rollbackFor = Exception.class)
    @Override
    public NaviPage<T> getNaviPager(T t, OrderByDto orderBy, Pager pager) {
        NaviPage<T> naviPage = new NaviPage<T>();
        naviPage.setList(getDao().getNaviPager(t, orderBy, pager));
        naviPage.setPager(pager);
        return naviPage;

    }

    @Transactional(readOnly = true,rollbackFor = Exception.class)
    @Override
    public NaviPage<T> getNaviPage(Pager pager){
        NaviPage<T> naviPage = new NaviPage<T>();
        naviPage.setList(getDao().getNaviPage(pager));
        naviPage.setPager(pager);
        return naviPage;
    }

}
