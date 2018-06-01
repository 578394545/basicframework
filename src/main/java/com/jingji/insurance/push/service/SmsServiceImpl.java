package com.jingji.insurance.push.service;

import com.jingji.insurance.push.util.SmsConfig;
import com.jingji.insurance.utils.DateUtil;
import com.jingji.insurance.utils.HttpClientUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 发送短信处理业务逻辑实现
 * @author Soar
 * @date 2018/5/30
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class SmsServiceImpl implements SmsService
{
	private static Logger log = LoggerFactory.getLogger(SmsServiceImpl.class);

	@Resource
	private SmsConfig smsConfig;

	@Override
	public boolean sendSms(String phone, String msg) {
		String url = smsConfig.getUrl();
		String[] urls = url.split("\\?");
		String parameterStr = urls[1].replaceFirst("@", msg).replaceFirst("@", phone).replaceFirst("@", "");

		log.info("URL:" + urls[0] + "?" + parameterStr);
		String retCode = conn(urls[0], parameterStr, "UTF8");
		String[] results = retCode.split(",");
		log.info("SMS：" + DateUtil.format(DateUtil.getUtcDate(), DateUtil.FMT_S_DATETIMES) + "，发送号码：" + phone + "，发送信息：" + msg + "，短信返回结果：" + retCode);
		return true;
	}

	/**
	 * 发送短息请求
	 * @param smsUrl
	 * @return
	 */
	private String conn(String smsUrl, String smsData, String encodeCharset)
	{
		return HttpClientUtil.sendPostRequest(smsUrl, smsData, encodeCharset);
	}

}
