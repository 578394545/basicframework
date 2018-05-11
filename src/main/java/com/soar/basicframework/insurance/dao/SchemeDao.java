package com.soar.basicframework.insurance.dao;

import com.soar.basicframework.base.BaseDao;
import com.soar.basicframework.insurance.model.Scheme;
import org.apache.ibatis.annotations.Mapper;

/**
 * 方案持久层接口
 * @author Soar
 * @date 2018/5/9
 */
@Mapper
public interface SchemeDao extends BaseDao<Scheme> {

}
