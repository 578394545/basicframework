package com.jingji.insurance.user.service;

import com.jingji.insurance.base.BaseDao;
import com.jingji.insurance.base.BaseServiceImpl;
import com.jingji.insurance.user.dao.UserDao;
import com.jingji.insurance.user.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * user服务层实现demo
 * @author Soar
 * @date 2018/4/21
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    @Resource
    private UserDao userDao;

    /**
     * 抽象方法，必须实现，返回DAO实例
     *
     * @return DAO实例
     */
    @Override
    public BaseDao<User> getDao() {
        return userDao;
    }
}
