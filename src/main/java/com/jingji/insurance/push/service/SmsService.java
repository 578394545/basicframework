package com.jingji.insurance.push.service;


/**
 * 发送短信service
 * @author Soar
 * @date 2018/5/30
 */
public interface SmsService 
{
	/**
	 * 
	 * @param phone
	 * @param msg
	 * @return
	 */
	public boolean sendSms(String phone, String msg);

}
