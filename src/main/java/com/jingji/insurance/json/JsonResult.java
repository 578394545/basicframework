package com.jingji.insurance.json;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.jingji.insurance.constant.GlobalResultStatus;
import com.jingji.insurance.utils.Pager;
import com.jingji.insurance.utils.ResultStatus;

/**
 * Json结果返回
 * @author Soar
 * @date 2018/5/2
 */
public class JsonResult 
{
	/**
	 * 返回无数据的成功结果
	 * 
	 * @return JSON结果
	 */
	public static Object success() 
	{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", GlobalResultStatus.SUCCESS.getCode());
		return map;
	}

	/**
	 * 返回成功结果
	 * 
	 * @param data 数据节点对象
	 * @return JSON结果
	 */
	public static Object success(Object data) 
	{
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		map.put("code", GlobalResultStatus.SUCCESS.getCode());
		map.put("data", data);
		return map;
	}

	/**
	 * 返回成功结果
	 * 
	 * @param data
	 *            数据节点对象
	 * @return JSON结果
	 */
	public static Object success(Map<String, Object> data) 
	{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", GlobalResultStatus.SUCCESS.getCode());
		map.put("data", data);
		return map;
	}

	/**
	 * 返回成功结果
	 * 
	 * @param list 数据列表
	 * @param pager 分页信息
	 * @return JSON结果
	 */
	public static Object success(List<?> list, Pager pager)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> subMap = new HashMap<String, Object>();
		subMap.put("list", list);
		subMap.put("pager", pager);
		map.put("code", GlobalResultStatus.SUCCESS.getCode());
		map.put("data", subMap);
		return map;
	}
	

	/**
	 * 返回失败结果
	 * 
	 * @param status 结果说明信息
	 * @return JSON结果
	 */
	public static Object fail(ResultStatus status)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", status.getCode());
		map.put("msg", status.getMsg());
		return map;
	}

	/**
	 * 返回失败结果
	 * 
	 * @param status 结果说明信息
	 * @param data 数据节点对象
	 * @return JSON结果
	 */
	public static Object fail(ResultStatus status, Object data) 
	{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", status.getCode());
		map.put("msg", status.getMsg());
		map.put("data", data);
		return map;
	}
}