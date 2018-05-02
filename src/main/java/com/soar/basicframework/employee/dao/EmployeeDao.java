package com.soar.basicframework.employee.dao;

import com.soar.basicframework.base.BaseDao;
import com.soar.basicframework.employee.model.Employee;
import org.apache.ibatis.annotations.Mapper;

/**
 * 员工信息持久层接口
 * @author Soar
 * @date 2018/5/2
 */
@Mapper
public interface EmployeeDao extends BaseDao<Employee> {
}
