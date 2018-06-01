package com.jingji.insurance.push.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 短信配置文件
 * @author Alone
 * @date 2015年12月22日 下午3:14:28
 *
 */
@Component("smsConfig")
public class SmsConfig
{
	@Value("${sms.url}")
	private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
