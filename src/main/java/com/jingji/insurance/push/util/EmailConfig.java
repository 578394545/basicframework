package com.jingji.insurance.push.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jingji.insurance.utils.StringUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


/**
 * 邮箱配置文件
 * @author Soar
 * @date 2018/5/30
 */
@Component("emailConfig")
public class EmailConfig
{
	@Value("${email.host}")
	private String host;

	@Value("${email.account}")
	private String account;

	@Value("${email.password}")
	private String password;

	@Value("${email.port}")
	private String port;

	@Value("${email.auth}")
	private String auth;

	public String getSendTo() {
		return sendTo;
	}

	public void setSendTo(String sendTo) {
		this.sendTo = sendTo;
	}

	@Value("${email.sendTo}")

	private String sendTo;
	
	/**
	 * 获取 邮箱通道，按照配置文件中url 的配置顺序
	 * @return
	 */
	public Map<String, String> getEmailUrlMap(){

		Map<String, String> urlMap =  new HashMap<String, String>();
			urlMap.put("host", host);
			urlMap.put("user", account);
			urlMap.put("password", password);
			urlMap.put("port", port);
			urlMap.put("auth",auth);

		return urlMap;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getAuth() {
		return auth;
	}

	public void setAuth(String auth) {
		this.auth = auth;
	}
}
