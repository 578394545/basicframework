package com.soar.basicframework.employee.controller;

import com.soar.basicframework.constant.EmployeeResultStatus;
import com.soar.basicframework.employee.model.Employee;
import com.soar.basicframework.employee.service.EmployeeService;
import com.soar.basicframework.json.JsonResult;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 员工信息管理控制器
 * @author Soar
 * @date 2018/5/2
 */
@RestController
@EnableAutoConfiguration
@RequestMapping("/employee")
public class EmployeeController {

    @Resource
    private EmployeeService employeeService;

    /**
     * 检查员工输入的信息是否正确
     * @return
     */
    @ResponseBody
    @RequestMapping("/checkEmployee")
    public Object checkEmployee() {
        Employee employee = new Employee();
        List<Employee> employeeList = employeeService.getList(employee);
        if(null == employeeList || employeeList.size() == 0){
            return JsonResult.fail(EmployeeResultStatus.EMPLOYEE_NOT_EXIST);
        }
        return JsonResult.success();
    }
}
