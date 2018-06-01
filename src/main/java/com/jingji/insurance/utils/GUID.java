package com.jingji.insurance.utils;

import java.util.UUID;
/**
 * 全局唯一标识符工具类。
 *
 * 引用了 java.util.UUID 类，去掉了中间的分割线
 * @author Soar
 * @date 2018/5/3
 */
public final class GUID {

	/**
	 * 获取32位随机字符串。
	 * 
	 * @return 32位随机字符串
	 */
	public static String getID(){
		return UUID.randomUUID().toString().replace("-", "");
	}

	/**
	 * 获取32位随机字符串，并截取中间8位
	 *
	 * @return
	 */
	public static String getPrimaryKeyId(){
		String id = UUID.randomUUID().toString().replace("-", "");
		return id.substring(7,15);
	}

}
