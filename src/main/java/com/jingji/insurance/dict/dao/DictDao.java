package com.jingji.insurance.dict.dao;

import com.jingji.insurance.base.BaseDao;
import com.jingji.insurance.dict.model.Dict;
import org.apache.ibatis.annotations.Mapper;

/**
 * 数据字典持久层接口
 * @author Soar
 * @date 2018/5/4
 */
@Mapper
public interface DictDao extends BaseDao<Dict> {
}
