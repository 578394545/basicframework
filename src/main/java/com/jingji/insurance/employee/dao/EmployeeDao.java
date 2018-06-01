package com.jingji.insurance.employee.dao;

import com.jingji.insurance.base.BaseDao;
import com.jingji.insurance.employee.model.Employee;
import org.apache.ibatis.annotations.Mapper;

/**
 * 员工信息持久层接口
 * @author Soar
 * @date 2018/5/2
 */
@Mapper
public interface EmployeeDao extends BaseDao<Employee> {
}
