package com.soar.basicframework.constant;

import com.soar.basicframework.utils.ResultStatus;

/**
 * 全局结果状态码
 * @author Soar
 * @date 2018/5/2
 */
public class GlobalResultStatus {
	public static final ResultStatus SUCCESS = new ResultStatus(0, "成功");

	public static final ResultStatus ERROR = new ResultStatus(100010200, "失败");
	public static final ResultStatus PARAM_MISSING = new ResultStatus(100010201, "缺少参数");

}
