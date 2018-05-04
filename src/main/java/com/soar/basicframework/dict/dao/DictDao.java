package com.soar.basicframework.dict.dao;

import com.soar.basicframework.base.BaseDao;
import com.soar.basicframework.dict.model.Dict;
import org.apache.ibatis.annotations.Mapper;

/**
 * 数据字典持久层接口
 * @author Soar
 * @date 2018/5/4
 */
@Mapper
public interface DictDao extends BaseDao<Dict> {
}
