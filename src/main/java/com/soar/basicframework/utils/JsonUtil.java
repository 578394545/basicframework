package com.soar.basicframework.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * json工具类
 * @author Soar
 * @date 2018/5/3
 *
 */
public class JsonUtil {
	private static Logger logger = LoggerFactory.getLogger(JsonUtil.class);
	private static ObjectMapper jsonParser = new ObjectMapper();

	/**
	 * json转指定类型
	 * @param json 目标字符串
	 * @param clazz 目标类型
	 * @param <T>
	 * @return
	 */
	public static <T> T json2Obj(String json,Class<T> clazz){
		if(json==null || "".equals(json)){
			return null;
		}
		try {
			return (T)jsonParser.readValue(json,clazz);
		} catch (Exception e) {
			logger.error("JSON转JAVA对象异常",e);
		} 
		return null;
	}

	/**
	 * 对象转json字符串
	 * @param obj
	 * @return
	 */
	public static String obj2Json(Object obj){
		if(obj==null){
			return null;
		}
		try {
			return jsonParser.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			logger.error("JAVA对象转JSON异常",e);
		}
		return null;
	}

	/**
	 * json字符串转List对象
	 * @param data
	 * @param clazz
	 * @param <T>
	 * @return
	 */
	public static <T> List<T> json2List(String data, Class<T> clazz) {
		List lstObjs = (List)json2Obj(data, List.class);
        List lstResult = new ArrayList(lstObjs.size());
        for (Iterator objIter = lstObjs.iterator(); objIter.hasNext(); ) {
          Object objT = jsonParser.convertValue(objIter.next(), clazz);
	      lstResult.add(objT);
        }
	     return lstResult;
	   }
}
