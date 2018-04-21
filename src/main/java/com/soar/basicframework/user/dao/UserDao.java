package com.soar.basicframework.user.dao;

import com.soar.basicframework.base.BaseDao;
import com.soar.basicframework.user.model.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * user持久层接口demo
 * @author Soar
 * @date 2018/4/21
 */
@Mapper
public interface UserDao extends BaseDao<User> {
}
