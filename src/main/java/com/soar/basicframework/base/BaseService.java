package com.soar.basicframework.base;

import com.soar.basicframework.utils.NaviPage;
import com.soar.basicframework.utils.OrderByDto;
import com.soar.basicframework.utils.Pager;

import java.io.Serializable;
import java.util.List;

/**
 * 为service实现提供的基础接口
 * @author Soar
 * @date 2018/4/21
 */
public interface BaseService<T>
{
    /**
     * 插入
     * @param t 插入的对象
     * @return 插入数据条数
     */
    int insert(T t);

    /**
     * 批量插入
     * @param list 数据列表
     * @return 插入数据条数
     */
    void insertList(List<T> list);
    
    /**
     * 修改
     * @param t 修改的数据
     * @return 修改的数据条数
     */
    void update(T t);

    /**
     * 删除
     * @param id 数据标识
     * @return 删除的数据条数
     */
    void delete(Serializable id);

    /**
     * 通过条件查询记录数
     * @param t 查询条件
     * @return 记录数
     */
    public int getTotal(T t);

    /**
     * 查询所有数据
     * @return 数据列表
     */
    List<T> getAll();
    
    /**
     * 通过条件查询数据列表
     * @param t 查询条件
     * @return 数据列表
     */    
    List<T> getList(T t);

    /**
     * 通过id查询数据
     * @param id 数据标识
     * @return 数据对象
     */
    T get(Serializable id);

    /**
     * 根据条件分页查询
     * @param t 查询参数
     * @param pager 分页
     * @return 分页数据列表
     */
    List<T> getPage(T t, Pager pager);

    /**
     * 根据条件分页查询
     * @param t 查询参数
     * @param orderBy 排序
     * @param pager 分页
     * @return 分页数据列表
     */
    List<T> getPage(T t, OrderByDto orderBy, Pager pager);

    /**
     * 根据条件分页查询 带分页参数及排序
     * @param t 查询参数
     * @param orderBy 排序
     * @param pager 分页
     * @return 分页数据列表
     */
    NaviPage<T> getNaviPager(T t, OrderByDto orderBy, Pager pager);

    /**
     * 根据条件分页查询 带分页参数
     * @param t 查询参数
     * @param pager 分页
     * @return
     */
    NaviPage<T> getNaviPage(T t, Pager pager);

    /**
     * 分页查询
     * @param pager 分页
     * @return
     */
    NaviPage<T> getNaviPage(Pager pager);


}
