package com.soar.basicframework.utils;

import com.soar.basicframework.constant.EmployeeResultStatus;
import com.soar.basicframework.employee.model.Employee;

import javax.servlet.http.HttpServletRequest;

/**
 * session工具类
 * @author Soar
 * @date 2018/5/7
 */
public class SessionUtil {

    /**
     * 检查session是否过期
     * @param request
     * @return
     */
    public static boolean checkSession(HttpServletRequest request){
        Employee employee = (Employee) request.getSession().getAttribute(EmployeeResultStatus.CURRENT_EMPLOYEE);
        if(null == employee){
            return false;
        }
        return true;
    }
}
