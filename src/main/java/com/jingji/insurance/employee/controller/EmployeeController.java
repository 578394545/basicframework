package com.jingji.insurance.employee.controller;

import com.jingji.insurance.constant.EmployeeResultStatus;
import com.jingji.insurance.constant.GlobalResultStatus;
import com.jingji.insurance.constant.InsuranceResultStatus;
import com.jingji.insurance.dict.model.Dict;
import com.jingji.insurance.dict.service.DictService;
import com.jingji.insurance.employee.model.Employee;
import com.jingji.insurance.employee.service.EmployeeService;
import com.jingji.insurance.json.JsonResult;
import com.jingji.insurance.utils.DateUtil;
import com.jingji.insurance.utils.StringUtil;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;
import java.util.Date;
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

    @Resource
    private DictService dictService;

    /**
     * 检查员工输入的信息是否正确
     * @return
     */
    @ResponseBody
    @RequestMapping("/checkEmployee")
    public Object checkEmployee(Employee employee,HttpServletRequest request) {
        if(null == employee || StringUtil.isEmpty(employee.getName()) || null == employee.getNumber()){
            return JsonResult.fail(GlobalResultStatus.PARAM_MISSING);
        }
        List<Employee> employeeList = employeeService.getList(employee);
        if(null == employeeList || employeeList.size() == 0){
            return JsonResult.fail(EmployeeResultStatus.EMPLOYEE_NOT_EXIST);
        }

        //默认投保日期
        Date insurance_date;
        Dict dict = dictService.get(EmployeeResultStatus.INSURANCE_DATE);
        Calendar calendar = Calendar.getInstance();
        if(null == dict){
            //没有字典项时默认为当年10月1日
            calendar.set((DateUtil.getYear(new Date())),9,1);
            insurance_date = calendar.getTime();
            int result = DateUtil.compare(new Date(),insurance_date);
            if(result == 1){
                return JsonResult.fail(InsuranceResultStatus.INSURED_EXPIRED);
            }
        }else{
            insurance_date = DateUtil.parse(dict.getDValue(),DateUtil.FMT_DATE);
            int result = DateUtil.compare(new Date(),insurance_date);
            if(result == 1){
                return JsonResult.fail(InsuranceResultStatus.INSURED_EXPIRED);
            }
        }
        request.getSession().setAttribute(EmployeeResultStatus.CURRENT_EMPLOYEE,employeeList.get(0));
        return JsonResult.success();
    }
}
