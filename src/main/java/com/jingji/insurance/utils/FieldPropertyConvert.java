package com.jingji.insurance.utils;

/**
 * 对象属性和数据库字段之间的转换
 * @author Soar
 * @date 2018/4/21
 *
 */
public class FieldPropertyConvert 
{
	public static void main(String[] args) 
	{
		System.out.println(propertyToField("userName"));
		System.out.println(fieldToProperty("user_name"));
	}

	/**
	 * 判断是否是大写字母
	 * 
	 * @param c
	 * @return
	 */
	public static Boolean isUp(char c) 
	{
		if (c >= 'A' && c <= 'Z') 
		{
			return true;
		}
		return false;
	}

	/**
	 * java对象属性转换为数据库字段，如userName-->user_name
	 * 
	 * @param property
	 * @return
	 */
	public static String propertyToField(String property)
	{
		if (null == property) 
		{
			return "";
		}
		char[] chars = property.toCharArray();
		StringBuffer field = new StringBuffer();
		for (char c : chars)
		{
			if (isUp(c)) 
			{
				field.append("_" + String.valueOf(c).toLowerCase());
			} 
			else 
			{
				field.append(c);
			}
		}
		return field.toString();
	}

	/**
	 * 将数据库字段转换为java属性，如user_name-->userName
	 * 
	 * @param field 字段名
	 * @return
	 */
	public static String fieldToProperty(String field)
	{
		if (null == field)
		{
			return "";
		}
		char[] chars = field.toCharArray();
		StringBuffer property = new StringBuffer();
		for (int i = 0; i < chars.length; i++)
		{
			char c = chars[i];
			if (c == '_')
			{
				int j = i + 1;
				if (j < chars.length)
				{
					property.append(String.valueOf(chars[j]).toUpperCase());
					i++;
				}
			} 
			else 
			{
				property.append(c);
			}
		}
		return property.toString();
	}
}
