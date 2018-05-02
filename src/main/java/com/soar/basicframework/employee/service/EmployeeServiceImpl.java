package com.soar.basicframework.employee.service;

import com.soar.basicframework.base.BaseDao;
import com.soar.basicframework.base.BaseServiceImpl;
import com.soar.basicframework.employee.dao.EmployeeDao;
import com.soar.basicframework.employee.model.Employee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 员工信息服务层实现
 * @author Soar
 * @date 2018/5/2
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class EmployeeServiceImpl extends BaseServiceImpl<Employee> implements EmployeeService {

    @Resource
    private EmployeeDao EmployeeDao;

    /**
     * 抽象方法，必须实现，返回DAO实例
     *
     * @return DAO实例
     */
    @Override
    public BaseDao<Employee> getDao() {
        return EmployeeDao;
    }
}
