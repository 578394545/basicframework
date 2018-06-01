package com.jingji.insurance.insurance.dao;

import com.jingji.insurance.base.BaseDao;
import com.jingji.insurance.insurance.model.Scheme;
import org.apache.ibatis.annotations.Mapper;

/**
 * 方案持久层接口
 * @author Soar
 * @date 2018/5/9
 */
@Mapper
public interface SchemeDao extends BaseDao<Scheme> {

}
