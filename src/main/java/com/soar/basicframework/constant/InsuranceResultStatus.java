package com.soar.basicframework.constant;

import com.soar.basicframework.utils.ResultStatus;

/**
 * 全局结果状态码
 * @author Soar
 * @date 2018/5/2
 */
public class InsuranceResultStatus {

	public static final ResultStatus INSURED_CANNOT_BE_EMPTY = new ResultStatus(100010301, "被投保人不能为空");
	public static final ResultStatus INSURED_ERROR = new ResultStatus(100010301, "被投保人信息有误");

}
