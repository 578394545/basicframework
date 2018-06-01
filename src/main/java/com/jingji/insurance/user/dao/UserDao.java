package com.jingji.insurance.user.dao;

import com.jingji.insurance.base.BaseDao;
import com.jingji.insurance.user.model.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * user持久层接口demo
 * @author Soar
 * @date 2018/4/21
 */
@Mapper
public interface UserDao extends BaseDao<User> {
}
