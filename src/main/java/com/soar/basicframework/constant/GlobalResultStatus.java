package com.soar.basicframework.constant;

import com.soar.basicframework.utils.ResultStatus;

/**
 * 全局结果状态码
 * @author Soar
 * @date 2018/5/2
 */
public class GlobalResultStatus {
	public static final ResultStatus SUCCESS = new ResultStatus(0, "成功");

	public static final ResultStatus ERROR = new ResultStatus(100010101, "失败");
	public static final ResultStatus PARAM_MISSING = new ResultStatus(100010102, "缺少参数");
	public static final ResultStatus BAD_MAILBOX_FORMAT = new ResultStatus(100010103, "邮箱格式错误！");
	public static final ResultStatus BAD_PHONE_FORMAT = new ResultStatus(100010104, "手机号码格式错误！");
	public static final ResultStatus USER_LOGIN_SESSION_TIME_OUT = new ResultStatus(100010105, "员工会话过期！");

}
