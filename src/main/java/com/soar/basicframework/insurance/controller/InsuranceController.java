package com.soar.basicframework.insurance.controller;

import com.soar.basicframework.constant.EmployeeResultStatus;
import com.soar.basicframework.insurance.model.PolicyholderInformation;
import com.soar.basicframework.insurance.service.InsuranceService;
import com.soar.basicframework.json.JsonResult;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 投保业务管理控制器
 * @author Soar
 * @date 2018/5/2
 */
@RestController
@EnableAutoConfiguration
@RequestMapping("/employee")
public class InsuranceController {

    @Resource
    private InsuranceService employeeService;

    /**
     * 检查员工输入的信息是否正确
     * @return
     */
    @ResponseBody
    @RequestMapping("/checkEmployee")
    public Object checkEmployee() {
        PolicyholderInformation employee = new PolicyholderInformation();
        List<PolicyholderInformation> employeeList = employeeService.getList(employee);
        if(null == employeeList || employeeList.size() == 0){
            return JsonResult.fail(EmployeeResultStatus.EMPLOYEE_NOT_EXIST);
        }
        return JsonResult.success();
    }
}
