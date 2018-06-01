package com.jingji.insurance.constant;

import com.jingji.insurance.utils.ResultStatus;

/**
 * 全局结果状态码
 * @author Soar
 * @date 2018/5/2
 */
public class EmployeeResultStatus {

	/**
	 * 当前登陆用户参数常量
	 */
	public static final String CURRENT_EMPLOYEE = "employee";

	/**
	 * 投保默认日期字典项
	 */
	public static final String INSURANCE_DATE = "insurance_date";

	public static final ResultStatus EMPLOYEE_NOT_EXIST = new ResultStatus(100010201, "员工不存在,验证不通过！");

}
