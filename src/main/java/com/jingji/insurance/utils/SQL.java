package com.jingji.insurance.utils;

import java.io.IOException;
import java.util.List;

/**
 * SQL条件拼接工具类
 * @author Soar
 * @date 2018/4/21
 */
public class SQL
{
    private static final String AND = " and ";
    
    private static final String OR = " or ";

    /**
     * 获得一个与逻辑相等式查询条件：and name = value
     * @param fieldName 字段名
     * @param fieldValue 数值
     * @param rejectedValue 被拒绝的数值
     * @return SQL条件语句
     */
    public static String andEqual(String fieldName, Number fieldValue, Number rejectedValue)
    {
        return create(AND, fieldName, "=", fieldValue, rejectedValue);
    }
    
    /**
     * 获得一个与逻辑相等式查询条件：and name = 'value'
     * @param fieldName 字段名
     * @param fieldValue 字段值
     * @return SQL条件语句
     */
    public static String andEqual(String fieldName, String fieldValue)
    {
        return create(AND, fieldName, "=", fieldValue);
    }

    /**
     * 获得一个与逻辑不等式查询条件：and name <> value
     * @param fieldName 字段名
     * @param fieldValue 数值
     * @param rejectedValue 被拒绝的数值
     * @return SQL条件语句
     */
    public static String andNotEqual(String fieldName, Number fieldValue, Number rejectedValue)
    {
        return create(AND, fieldName, "<>", fieldValue, rejectedValue);
    }
    
    /**
     * 获得一个与逻辑不等式查询条件：and name <> 'value'
     * @param fieldName 字段名
     * @param fieldValue 字段值
     * @return SQL条件语句
     */
    public static String andNotEqual(String fieldName, String fieldValue)
    {
        return create(AND, fieldName, "<>", fieldValue);
    }

    /**
     * 获得一个与逻辑小于式查询条件：and name < value
     * @param fieldName 字段名
     * @param fieldValue 数值
     * @param rejectedValue 被拒绝的数值
     * @return SQL条件语句
     */
    public static String andLess(String fieldName, Number fieldValue, Number rejectedValue)
    {
        return create(AND, fieldName, "<", fieldValue, rejectedValue);
    }
    
    /**
     * 获得一个与逻辑小于式查询条件：and name < 'value'
     * @param fieldName 字段名
     * @param fieldValue 字段值
     * @return SQL条件语句
     */
    public static String andLess(String fieldName, String fieldValue)
    {
        return create(AND, fieldName, "<", fieldValue);
    }

    /**
     * 获得一个与逻辑小于等于式查询条件：and name <= value
     * @param fieldName 字段名
     * @param fieldValue 数值
     * @param rejectedValue 被拒绝的数值
     * @return SQL条件语句
     */
    public static String andLessEqual(String fieldName, Number fieldValue, Number rejectedValue)
    {
        return create(AND, fieldName, "<=", fieldValue, rejectedValue);
    }
    
    /**
     * 获得一个与逻辑小于等于式查询条件：and name <= 'value'
     * @param fieldName 字段名
     * @param fieldValue 字段值
     * @return SQL条件语句
     */
    public static String andLessEqual(String fieldName, String fieldValue)
    {
        return create(AND, fieldName, "<=", fieldValue);
    }

    /**
     * 获得一个与逻辑大于式查询条件：and name > value
     * @param fieldName 字段名
     * @param fieldValue 数值
     * @param rejectedValue 被拒绝的数值
     * @return SQL条件语句
     */
    public static String andGreat(String fieldName, Number fieldValue, Number rejectedValue)
    {
        return create(AND, fieldName, ">", fieldValue, rejectedValue);
    }
    
    /**
     * 获得一个与逻辑大于式查询条件：and name > 'value'
     * @param fieldName 字段名
     * @param fieldValue 字段值
     * @return SQL条件语句
     */
    public static String andGreat(String fieldName, String fieldValue)
    {
        return create(AND, fieldName, ">", fieldValue);
    }

    /**
     * 获得一个与逻辑大于等于式查询条件：and name >= value
     * @param fieldName 字段名
     * @param fieldValue 数值
     * @param rejectedValue 被拒绝的数值
     * @return SQL条件语句
     */
    public static String andGreatEqual(String fieldName, Number fieldValue, Number rejectedValue)
    {
        return create(AND, fieldName, ">=", fieldValue, rejectedValue);
    }
    
    /**
     * 获得一个与逻辑大于等于式查询条件：and name >= 'value'
     * @param fieldName 字段名
     * @param fieldValue 字段值
     * @return SQL条件语句
     */
    public static String andGreatEqual(String fieldName, String fieldValue)
    {
        return create(AND, fieldName, ">=", fieldValue);
    }

    /**
     * 获得一个与逻辑全模糊匹配格式的查询条件：and name like '%value%'
     * @param fieldName 字段名
     * @param fieldValue 字段值
     * @return SQL条件语句
     */
    public static String andLike(String fieldName, String fieldValue)
    {
        return createLike(AND, fieldName, "like", "%", fieldValue, "%");
    }

    /**
     * 获得一个与逻辑非全模糊匹配格式的查询条件：and name not like '%value%'
     * @param fieldName 字段名
     * @param fieldValue 字段值
     * @return SQL条件语句
     */
    public static String andNotLike(String fieldName, String fieldValue)
    {
        return createLike(AND, fieldName, "not like", "%", fieldValue, "%");
    }

    /**
     * 获得一个与逻辑左模糊匹配格式的查询条件：and name like '%value'
     * @param fieldName 字段名
     * @param fieldValue 字段值
     * @return SQL条件语句
     */
    public static String andLikeLeft(String fieldName, String fieldValue)
    {
        return createLike(AND, fieldName, "like", "%", fieldValue, "");
    }

    /**
     * 获得一个与逻辑非左模糊匹配格式的查询条件：and name not like '%value'
     * @param fieldName 字段名
     * @param fieldValue 字段值
     * @return SQL条件语句
     */
    public static String andNotLikeLeft(String fieldName, String fieldValue)
    {
        return createLike(AND, fieldName, "not like", "%", fieldValue, "");
    }

    /**
     * 获得一个与逻辑右模糊匹配格式的查询条件：and name like 'value%'
     * @param fieldName 字段名
     * @param fieldValue 字段值
     * @return SQL条件语句
     */
    public static String andLikeRight(String fieldName, String fieldValue)
    {
        return createLike(AND, fieldName, "like", "", fieldValue, "%");
    }

    /**
     * 获得一个与逻辑非右模糊匹配格式的查询条件：and name not like 'value%'
     * @param fieldName 字段名
     * @param fieldValue 字段值
     * @return SQL条件语句
     */
    public static String andNotLikeRight(String fieldName, String fieldValue)
    {
        return createLike(AND, fieldName, "not like", "", fieldValue, "%");
    }

    /**
     * 获得一个与逻辑的in的查询条件，自动检测类型：and name in (1,2,3)或者and name in ('a','b')
     * @param fieldName 字段名
     * @param fieldValues 字段值
     * @return SQL条件语句
     */
    public static String andIn(String fieldName, Object[] fieldValues)
    {
    	return createIn(AND, fieldName, "in", fieldValues);
    }
    
    /**
     * 获得一个与逻辑的in数字的查询条件：and name in (1,2,3)
     * @param fieldName 字段名
     * @param fieldValues 字段值
     * @return SQL条件语句
     */
    public static String andInNumber(String fieldName, Object[] fieldValues)
    {
    	return createInNumber(AND, fieldName, "in", fieldValues);
    }
    
    /**
     * 获得一个与逻辑的in字符串的查询条件：and name in ('a','b')
     * @param fieldName 字段名
     * @param fieldValues 字段值
     * @return SQL条件语句
     */
    public static String andInString(String fieldName, Object[] fieldValues)
    {
    	return createInString(AND, fieldName, "in", fieldValues);
    }

    /**
     * 获得一个与逻辑的not in的查询条件，自动检测类型：and name not in (1,2,3)或者and name not in ('a','b')
     * @param fieldName 字段名
     * @param fieldValues 字段值
     * @return SQL条件语句
     */
    public static String andNotIn(String fieldName, Object[] fieldValues)
    {
    	return createIn(AND, fieldName, "not in", fieldValues);
    }
    
    /**
     * 获得一个与逻辑的not in数字的查询条件：and name not in (1,2,3)
     * @param fieldName 字段名
     * @param fieldValues 字段值
     * @return SQL条件语句
     */
    public static String andNotInNumber(String fieldName, Object[] fieldValues)
    {
    	return createInNumber(AND, fieldName, "not in", fieldValues);
    }
    
    /**
     * 获得一个与逻辑的not in字符串的查询条件：and name not in ('a','b')
     * @param fieldName 字段名
     * @param fieldValues 字段值
     * @return SQL条件语句
     */
    public static String andNotInString(String fieldName, Object[] fieldValues)
    {
    	return createInString(AND, fieldName, "not in", fieldValues);
    }
    
    /**
     * 获得一个与逻辑相等式查询条件：or name = value
     * @param fieldName 字段名
     * @param fieldValue 数值
     * @param rejectedValue 被拒绝的数值
     * @return SQL条件语句
     */
    public static String orEqual(String fieldName, Number fieldValue, Number rejectedValue)
    {
        return create(OR, fieldName, "=", fieldValue, rejectedValue);
    }
    
    /**
     * 获得一个或逻辑相等式查询条件：or name = 'value'
     * @param fieldName 字段名
     * @param fieldValue 字段值
     * @return SQL条件语句
     */
    public static String orEqual(String fieldName, String fieldValue)
    {
        return create(OR, fieldName, "=", fieldValue);
    }

    /**
     * 获得一个或逻辑不等式查询条件：or name <> value
     * @param fieldName 字段名
     * @param fieldValue 数值
     * @param rejectedValue 被拒绝的数值
     * @return SQL条件语句
     */
    public static String orNotEqual(String fieldName, Number fieldValue, Number rejectedValue)
    {
        return create(OR, fieldName, "<>", fieldValue, rejectedValue);
    }
    
    /**
     * 获得一个或逻辑不等式查询条件：or name <> 'value'
     * @param fieldName 字段名
     * @param fieldValue 字段值
     * @return SQL条件语句
     */
    public static String orNotEqual(String fieldName, String fieldValue)
    {
        return create(OR, fieldName, "<>", fieldValue);
    }

    /**
     * 获得一个或逻辑小于式查询条件：or name < value
     * @param fieldName 字段名
     * @param fieldValue 数值
     * @param rejectedValue 被拒绝的数值
     * @return SQL条件语句
     */
    public static String orLess(String fieldName, Number fieldValue, Number rejectedValue)
    {
        return create(OR, fieldName, "<", fieldValue, rejectedValue);
    }
    
    /**
     * 获得一个或逻辑小于式查询条件：or name < 'value'
     * @param fieldName 字段名
     * @param fieldValue 字段值
     * @return SQL条件语句
     */
    public static String orLess(String fieldName, String fieldValue)
    {
        return create(OR, fieldName, "<", fieldValue);
    }

    /**
     * 获得一个或逻辑小于等于式查询条件：or name <= value
     * @param fieldName 字段名
     * @param fieldValue 数值
     * @param rejectedValue 被拒绝的数值
     * @return SQL条件语句
     */
    public static String orLessEqual(String fieldName, Number fieldValue, Number rejectedValue)
    {
        return create(OR, fieldName, "<=", fieldValue, rejectedValue);
    }
    
    /**
     * 获得一个或逻辑小于等于式查询条件：or name <= 'value'
     * @param fieldName 字段名
     * @param fieldValue 字段值
     * @return SQL条件语句
     */
    public static String orLessEqual(String fieldName, String fieldValue)
    {
        return create(OR, fieldName, "<=", fieldValue);
    }

    /**
     * 获得一个或逻辑大于式查询条件：or name > value
     * @param fieldName 字段名
     * @param fieldValue 数值
     * @param rejectedValue 被拒绝的数值
     * @return SQL条件语句
     */
    public static String orGreat(String fieldName, Number fieldValue, Number rejectedValue)
    {
        return create(OR, fieldName, ">", fieldValue, rejectedValue);
    }
    
    /**
     * 获得一个或逻辑大于式查询条件：or name > 'value'
     * @param fieldName 字段名
     * @param fieldValue 字段值
     * @return SQL条件语句
     */
    public static String orGreat(String fieldName, String fieldValue)
    {
        return create(OR, fieldName, ">", fieldValue);
    }

    /**
     * 获得一个或逻辑大于等于式查询条件：or name >= value
     * @param fieldName 字段名
     * @param fieldValue 数值
     * @param rejectedValue 被拒绝的数值
     * @return SQL条件语句
     */
    public static String orGreatEqual(String fieldName, Number fieldValue, Number rejectedValue)
    {
        return create(OR, fieldName, ">=", fieldValue, rejectedValue);
    }
    
    /**
     * 获得一个或逻辑大于等于式查询条件：or name >= 'value'
     * @param fieldName 字段名
     * @param fieldValue 字段值
     * @return SQL条件语句
     */
    public static String orGreatEqual(String fieldName, String fieldValue)
    {
        return create(OR, fieldName, ">=", fieldValue);
    }

    /**
     * 获得一个或逻辑全模糊匹配格式的查询条件：or name like '%value%'
     * @param fieldName 字段名
     * @param fieldValue 字段值
     * @return SQL条件语句
     */
    public static String orLike(String fieldName, String fieldValue)
    {
        return createLike(OR, fieldName, "like", "%", fieldValue, "%");
    }

    /**
     * 获得一个或逻辑非全模糊匹配格式的查询条件：or name not like '%value%'
     * @param fieldName 字段名
     * @param fieldValue 字段值
     * @return SQL条件语句
     */
    public static String orNotLike(String fieldName, String fieldValue)
    {
        return createLike(OR, fieldName, "not like", "%", fieldValue, "%");
    }

    /**
     * 获得一个或逻辑左模糊匹配格式的查询条件：or name like '%value'
     * @param fieldName 字段名
     * @param fieldValue 字段值
     * @return SQL条件语句
     */
    public static String orLikeLeft(String fieldName, String fieldValue)
    {
        return createLike(OR, fieldName, "like", "%", fieldValue, "");
    }

    /**
     * 获得一个或逻辑非左模糊匹配格式的查询条件：or name not like '%value'
     * @param fieldName 字段名
     * @param fieldValue 字段值
     * @return SQL条件语句
     */
    public static String orNotLikeLeft(String fieldName, String fieldValue)
    {
        return createLike(OR, fieldName, "not like", "%", fieldValue, "");
    }

    /**
     * 获得一个或逻辑右模糊匹配格式的查询条件：or name like 'value%'
     * @param fieldName 字段名
     * @param fieldValue 字段值
     * @return SQL条件语句
     */
    public static String orLikeRight(String fieldName, String fieldValue)
    {
        return createLike(OR, fieldName, "like", "", fieldValue, "%");
    }

    /**
     * 获得一个或逻辑非右模糊匹配格式的查询条件：or name not like 'value%'
     * @param fieldName 字段名
     * @param fieldValue 字段值
     * @return SQL条件语句
     */
    public static String orNotLikeRight(String fieldName, String fieldValue)
    {
        return createLike(OR, fieldName, "not like", "", fieldValue, "%");
    }

    /**
     * 获得一个或逻辑的in的查询条件，自动检测类型：or name in (1,2,3)或者or name in ('a','b')
     * @param fieldName 字段名
     * @param fieldValues 字段值
     * @return SQL条件语句
     */
    public static String orIn(String fieldName, Object[] fieldValues)
    {
    	return createIn(OR, fieldName, "or", fieldValues);
    }
    
    /**
     * 获得一个或逻辑的in数字的查询条件：or name in (1,2,3)
     * @param fieldName 字段名
     * @param fieldValues 字段值
     * @return SQL条件语句
     */
    public static String orInNumber(String fieldName, Object[] fieldValues)
    {
    	return createInNumber(OR, fieldName, "in", fieldValues);
    }
    
    /**
     * 获得一个或逻辑的in字符串的查询条件：or name in ('a','b')
     * @param fieldName 字段名
     * @param fieldValues 字段值
     * @return SQL条件语句
     */
    public static String orInString(String fieldName, Object[] fieldValues)
    {
    	return createInString(OR, fieldName, "in", fieldValues);
    }

    /**
     * 获得一个或逻辑的not in的查询条件，自动检测类型：or name not in (1,2,3)或者or name not in ('a','b')
     * @param fieldName 字段名
     * @param fieldValues 字段值
     * @return SQL条件语句
     */
    public static String orNotIn(String fieldName, Object[] fieldValues)
    {
    	return createIn(OR, fieldName, "not in", fieldValues);
    }
    
    /**
     * 获得一个或逻辑的not in数字的查询条件：or name not in (1,2,3)
     * @param fieldName 字段名
     * @param fieldValues 字段值
     * @return SQL条件语句
     */
    public static String orNotInNumber(String fieldName, Object[] fieldValues)
    {
    	return createInNumber(OR, fieldName, "not in", fieldValues);
    }
    
    /**
     * 获得一个或逻辑的not in字符串的查询条件：or name not in ('a','b')
     * @param fieldName 字段名
     * @param fieldValues 字段值
     * @return SQL条件语句
     */
    public static String orNotInString(String fieldName, Object[] fieldValues)
    {
    	return createInString(OR, fieldName, "not in", fieldValues);
    }

    /**
     * 向SQL语句中添加一个与逻辑相等式查询条件：and name = value
     * @param sql SQL语句
     * @param fieldName 字段名
     * @param fieldValue 数值
     * @param rejectedValue 被拒绝的数值
     */
    public static void andEqual(Appendable sql, String fieldName, Number fieldValue, Number rejectedValue)
    {
        append(sql, AND, fieldName, "=", fieldValue, rejectedValue);
    }
    
    /**
     * 向SQL语句中添加一个与逻辑相等式查询条件：and name = 'value'
     * @param sql SQL语句
     * @param fieldName 字段名
     * @param fieldValue 字段值
     */
    public static void andEqual(Appendable sql, String fieldName, String fieldValue)
    {
        append(sql, AND, fieldName, "=", fieldValue);
    }

    /**
     * 向SQL语句中添加一个与逻辑不等式查询条件：and name <> value
     * @param sql SQL语句
     * @param fieldName 字段名
     * @param fieldValue 数值
     * @param rejectedValue 被拒绝的数值
     */
    public static void andNotEqual(Appendable sql, String fieldName, Number fieldValue, Number rejectedValue)
    {
        append(sql, AND, fieldName, "<>", fieldValue, rejectedValue);
    }
    
    /**
     * 向SQL语句中添加一个与逻辑不等式查询条件：and name <> 'value'
     * @param sql SQL语句
     * @param fieldName 字段名
     * @param fieldValue 字段值
     */
    public static void andNotEqual(Appendable sql, String fieldName, String fieldValue)
    {
        append(sql, AND, fieldName, "<>", fieldValue);
    }

    /**
     * 向SQL语句中添加一个与逻辑小于式查询条件：and name < value
     * @param sql SQL语句
     * @param fieldName 字段名
     * @param fieldValue 数值
     * @param rejectedValue 被拒绝的数值
     */
    public static void andLess(Appendable sql, String fieldName, Number fieldValue, Number rejectedValue)
    {
        append(sql, AND, fieldName, "<", fieldValue, rejectedValue);
    }
    
    /**
     * 向SQL语句中添加一个与逻辑小于式查询条件：and name < 'value'
     * @param sql SQL语句
     * @param fieldName 字段名
     * @param fieldValue 字段值
     */
    public static void andLess(Appendable sql, String fieldName, String fieldValue)
    {
        append(sql, AND, fieldName, "<", fieldValue);
    }

    /**
     * 向SQL语句中添加一个与逻辑小于等于式查询条件：and name <= value
     * @param sql SQL语句
     * @param fieldName 字段名
     * @param fieldValue 数值
     * @param rejectedValue 被拒绝的数值
     */
    public static void andLessEqual(Appendable sql, String fieldName, Number fieldValue, Number rejectedValue)
    {
        append(sql, AND, fieldName, "<=", fieldValue, rejectedValue);
    }
    
    /**
     * 向SQL语句中添加一个与逻辑小于等于式查询条件：and name <= 'value'
     * @param sql SQL语句
     * @param fieldName 字段名
     * @param fieldValue 字段值
     */
    public static void andLessEqual(Appendable sql, String fieldName, String fieldValue)
    {
        append(sql, AND, fieldName, "<=", fieldValue);
    }

    /**
     * 向SQL语句中添加一个与逻辑大于式查询条件：and name > value
     * @param sql SQL语句
     * @param fieldName 字段名
     * @param fieldValue 数值
     * @param rejectedValue 被拒绝的数值
     */
    public static void andGreat(Appendable sql, String fieldName, Number fieldValue, Number rejectedValue)
    {
        append(sql, AND, fieldName, ">", fieldValue, rejectedValue);
    }
    
    /**
     * 向SQL语句中添加一个与逻辑大于式查询条件：and name > 'value'
     * @param sql SQL语句
     * @param fieldName 字段名
     * @param fieldValue 字段值
     */
    public static void andGreat(Appendable sql, String fieldName, String fieldValue)
    {
        append(sql, AND, fieldName, ">", fieldValue);
    }

    /**
     * 向SQL语句中添加一个与逻辑大于等于式查询条件：and name >= value
     * @param sql SQL语句
     * @param fieldName 字段名
     * @param fieldValue 数值
     * @param rejectedValue 被拒绝的数值
     */
    public static void andGreatEqual(Appendable sql, String fieldName, Number fieldValue, Number rejectedValue)
    {
        append(sql, AND, fieldName, ">=", fieldValue, rejectedValue);
    }
    
    /**
     * 向SQL语句中添加一个与逻辑大于等于式查询条件：and name >= 'value'
     * @param sql SQL语句
     * @param fieldName 字段名
     * @param fieldValue 字段值
     */
    public static void andGreatEqual(Appendable sql, String fieldName, String fieldValue)
    {
        append(sql, AND, fieldName, ">=", fieldValue);
    }

    /**
     * 向SQL语句中添加一个与逻辑全模糊匹配格式的查询条件：and name like '%value%'
     * @param sql SQL语句
     * @param fieldName 字段名
     * @param fieldValue 字段值
     */
    public static void andLike(Appendable sql, String fieldName, String fieldValue)
    {
        appendLike(sql, AND, fieldName, "like", "%", fieldValue, "%");
    }

    /**
     * 向SQL语句中添加一个与逻辑非全模糊匹配格式的查询条件：and name not like '%value%'
     * @param sql SQL语句
     * @param fieldName 字段名
     * @param fieldValue 字段值
     */
    public static void andNotLike(Appendable sql, String fieldName, String fieldValue)
    {
        appendLike(sql, AND, fieldName, "not like", "%", fieldValue, "%");
    }

    /**
     * 向SQL语句中添加一个与逻辑左模糊匹配格式的查询条件：and name like '%value'
     * @param sql SQL语句
     * @param fieldName 字段名
     * @param fieldValue 字段值
     */
    public static void andLikeLeft(Appendable sql, String fieldName, String fieldValue)
    {
        appendLike(sql, AND, fieldName, "like", "%", fieldValue, "");
    }

    /**
     * 向SQL语句中添加一个与逻辑非左模糊匹配格式的查询条件：and name not like '%value'
     * @param sql SQL语句
     * @param fieldName 字段名
     * @param fieldValue 字段值
     */
    public static void andNotLikeLeft(Appendable sql, String fieldName, String fieldValue)
    {
        appendLike(sql, AND, fieldName, "not like", "%", fieldValue, "");
    }

    /**
     * 向SQL语句中添加一个与逻辑右模糊匹配格式的查询条件：and name like 'value%'
     * @param sql SQL语句
     * @param fieldName 字段名
     * @param fieldValue 字段值
     */
    public static void andLikeRight(Appendable sql, String fieldName, String fieldValue)
    {
        appendLike(sql, AND, fieldName, "like", "", fieldValue, "%");
    }

    /**
     * 向SQL语句中添加一个与逻辑非右模糊匹配格式的查询条件：and name not like 'value%'
     * @param sql SQL语句
     * @param fieldName 字段名
     * @param fieldValue 字段值
     */
    public static void andNotLikeRight(Appendable sql, String fieldName, String fieldValue)
    {
        appendLike(sql, AND, fieldName, "not like", "", fieldValue, "%");
    }

    /**
     * 获得一个与逻辑的in的查询条件，自动检测类型：and name in (1,2,3)或者and name in ('a','b')
     * @param sql SQL语句
     * @param fieldName 字段名
     * @param fieldValues 字段值
     */
    public static void andIn(Appendable sql, String fieldName, Object[] fieldValues)
    {
    	appendIn(sql, AND, fieldName, "in", fieldValues);
    }
    
    /**
     * 获得一个与逻辑的in数字的查询条件：and name in (1,2,3)
     * @param sql SQL语句
     * @param fieldName 字段名
     * @param fieldValues 字段值
     */
    public static void andInNumber(Appendable sql, String fieldName, Object[] fieldValues)
    {
    	appendInNumber(sql, AND, fieldName, "in", fieldValues);
    }
    
    /**
     * 获得一个与逻辑的in字符串的查询条件：and name in ('a','b')
     * @param sql SQL语句
     * @param fieldName 字段名
     * @param fieldValues 字段值
     */
    public static void andInString(Appendable sql, String fieldName, Object[] fieldValues)
    {
    	appendInString(sql, AND, fieldName, "in", fieldValues);
    }

    /**
     * 获得一个与逻辑的not in的查询条件，自动检测类型：and name not in (1,2,3)或者and name not in ('a','b')
     * @param sql SQL语句
     * @param fieldName 字段名
     * @param fieldValues 字段值
     */
    public static void andNotIn(Appendable sql, String fieldName, Object[] fieldValues)
    {
    	appendIn(sql, AND, fieldName, "not in", fieldValues);
    }
    
    /**
     * 获得一个与逻辑的not in数字的查询条件：and name not in (1,2,3)
     * @param sql SQL语句
     * @param fieldName 字段名
     * @param fieldValues 字段值
     */
    public static void andNotInNumber(Appendable sql, String fieldName, Object[] fieldValues)
    {
    	appendInNumber(sql, AND, fieldName, "not in", fieldValues);
    }
    
    /**
     * 获得一个与逻辑的not in字符串的查询条件：and name not in ('a','b')
     * @param sql SQL语句
     * @param fieldName 字段名
     * @param fieldValues 字段值
     */
    public static void andNotInString(Appendable sql, String fieldName, Object[] fieldValues)
    {
    	appendInString(sql, AND, fieldName, "not in", fieldValues);
    }
    
    /**
     * 向SQL语句中添加一个或逻辑相等式查询条件：or name = value
     * @param sql SQL语句
     * @param fieldName 字段名
     * @param fieldValue 数值
     * @param rejectedValue 被拒绝的数值
     */
    public static void orEqual(Appendable sql, String fieldName, Number fieldValue, Number rejectedValue)
    {
        append(sql, OR, fieldName, "=", fieldValue, rejectedValue);
    }
    
    /**
     * 向SQL语句中添加一个或逻辑相等式查询条件：or name = 'value'
     * @param sql SQL语句
     * @param fieldName 字段名
     * @param fieldValue 字段值
     */
    public static void orEqual(Appendable sql, String fieldName, String fieldValue)
    {
        append(sql, OR, fieldName, "=", fieldValue);
    }

    /**
     * 向SQL语句中添加一个或逻辑不等式查询条件：or name <> value
     * @param sql SQL语句
     * @param fieldName 字段名
     * @param fieldValue 数值
     * @param rejectedValue 被拒绝的数值
     */
    public static void orNotEqual(Appendable sql, String fieldName, Number fieldValue, Number rejectedValue)
    {
        append(sql, OR, fieldName, "<>", fieldValue, rejectedValue);
    }
    
    /**
     * 向SQL语句中添加一个或逻辑不等式查询条件：or name <> 'value'
     * @param sql SQL语句
     * @param fieldName 字段名
     * @param fieldValue 字段值
     */
    public static void orNotEqual(Appendable sql, String fieldName, String fieldValue)
    {
        append(sql, OR, fieldName, "<>", fieldValue);
    }

    /**
     * 向SQL语句中添加一个或逻辑小于式查询条件：or name < value
     * @param sql SQL语句
     * @param fieldName 字段名
     * @param fieldValue 数值
     * @param rejectedValue 被拒绝的数值
     */
    public static void orLess(Appendable sql, String fieldName, Number fieldValue, Number rejectedValue)
    {
        append(sql, OR, fieldName, "<", fieldValue, rejectedValue);
    }
    
    /**
     * 向SQL语句中添加一个或逻辑小于式查询条件：or name < 'value'
     * @param sql SQL语句
     * @param fieldName 字段名
     * @param fieldValue 字段值
     */
    public static void orLess(Appendable sql, String fieldName, String fieldValue)
    {
        append(sql, OR, fieldName, "<", fieldValue);
    }

    /**
     * 向SQL语句中添加一个或逻辑小于等于式查询条件：or name <= value
     * @param sql SQL语句
     * @param fieldName 字段名
     * @param fieldValue 数值
     * @param rejectedValue 被拒绝的数值
     */
    public static void orLessEqual(Appendable sql, String fieldName, Number fieldValue, Number rejectedValue)
    {
        append(sql, OR, fieldName, "<=", fieldValue, rejectedValue);
    }
    
    /**
     * 向SQL语句中添加一个或逻辑小于等于式查询条件：or name <= 'value'
     * @param sql SQL语句
     * @param fieldName 字段名
     * @param fieldValue 字段值
     */
    public static void orLessEqual(Appendable sql, String fieldName, String fieldValue)
    {
        append(sql, OR, fieldName, "<=", fieldValue);
    }

    /**
     * 向SQL语句中添加一个或逻辑大于式查询条件：or name > value
     * @param sql SQL语句
     * @param fieldName 字段名
     * @param fieldValue 数值
     * @param rejectedValue 被拒绝的数值
     */
    public static void orGreat(Appendable sql, String fieldName, Number fieldValue, Number rejectedValue)
    {
        append(sql, OR, fieldName, ">", fieldValue, rejectedValue);
    }
    
    /**
     * 向SQL语句中添加一个或逻辑大于式查询条件：or name > 'value'
     * @param sql SQL语句
     * @param fieldName 字段名
     * @param fieldValue 字段值
     */
    public static void orGreat(Appendable sql, String fieldName, String fieldValue)
    {
        append(sql, OR, fieldName, ">", fieldValue);
    }

    /**
     * 向SQL语句中添加一个或逻辑大于等于式查询条件：or name >= value
     * @param sql SQL语句
     * @param fieldName 字段名
     * @param fieldValue 数值
     * @param rejectedValue 被拒绝的数值
     */
    public static void orGreatEqual(Appendable sql, String fieldName, Number fieldValue, Number rejectedValue)
    {
        append(sql, OR, fieldName, ">=", fieldValue, rejectedValue);
    }
    
    /**
     * 向SQL语句中添加一个或逻辑大于等于式查询条件：or name >= 'value'
     * @param sql SQL语句
     * @param fieldName 字段名
     * @param fieldValue 字段值
     */
    public static void orGreatEqual(Appendable sql, String fieldName, String fieldValue)
    {
        append(sql, OR, fieldName, ">=", fieldValue);
    }

    /**
     * 向SQL语句中添加一个或逻辑全模糊匹配格式的查询条件：or name like '%value%'
     * @param sql SQL语句
     * @param fieldName 字段名
     * @param fieldValue 字段值
     */
    public static void orLike(Appendable sql, String fieldName, String fieldValue)
    {
        appendLike(sql, OR, fieldName, "like", "%", fieldValue, "%");
    }

    /**
     * 向SQL语句中添加一个或逻辑非全模糊匹配格式的查询条件：or name not like '%value%'
     * @param sql SQL语句
     * @param fieldName 字段名
     * @param fieldValue 字段值
     */
    public static void orNotLike(Appendable sql, String fieldName, String fieldValue)
    {
        appendLike(sql, OR, fieldName, "not like", "%", fieldValue, "%");
    }

    /**
     * 向SQL语句中添加一个或逻辑左模糊匹配格式的查询条件：or name like '%value'
     * @param sql SQL语句
     * @param fieldName 字段名
     * @param fieldValue 字段值
     */
    public static void orLikeLeft(Appendable sql, String fieldName, String fieldValue)
    {
        appendLike(sql, OR, fieldName, "like", "%", fieldValue, "");
    }

    /**
     * 向SQL语句中添加一个或逻辑非左模糊匹配格式的查询条件：or name not like '%value'
     * @param sql SQL语句
     * @param fieldName 字段名
     * @param fieldValue 字段值
     */
    public static void orNotLikeLeft(Appendable sql, String fieldName, String fieldValue)
    {
        appendLike(sql, OR, fieldName, "not like", "%", fieldValue, "");
    }

    /**
     * 向SQL语句中添加一个或逻辑右模糊匹配格式的查询条件：or name like 'value%'
     * @param sql SQL语句
     * @param fieldName 字段名
     * @param fieldValue 字段值
     */
    public static void orLikeRight(Appendable sql, String fieldName, String fieldValue)
    {
        appendLike(sql, OR, fieldName, "like", "", fieldValue, "%");
    }

    /**
     * 向SQL语句中添加一个或逻辑非右模糊匹配格式的查询条件：or name not like 'value%'
     * @param sql SQL语句
     * @param fieldName 字段名
     * @param fieldValue 字段值
     */
    public static void orNotLikeRight(Appendable sql, String fieldName, String fieldValue)
    {
        appendLike(sql, OR, fieldName, "not like", "", fieldValue, "%");
    }

    /**
     * 获得一个或逻辑的in的查询条件，自动检测类型：or name in (1,2,3)或者or name in ('a','b')
     * @param sql SQL语句
     * @param fieldName 字段名
     * @param fieldValues 字段值
     */
    public static void orIn(Appendable sql, String fieldName, Object[] fieldValues)
    {
    	appendIn(sql, OR, fieldName, "in", fieldValues);
    }
    
    /**
     * 获得一个或逻辑的in数字的查询条件：or name in (1,2,3)
     * @param sql SQL语句
     * @param fieldName 字段名
     * @param fieldValues 字段值
     */
    public static void orInNumber(Appendable sql, String fieldName, Object[] fieldValues)
    {
    	appendInNumber(sql, OR, fieldName, "in", fieldValues);
    }
    
    /**
     * 获得一个或逻辑的in字符串的查询条件：or name in ('a','b')
     * @param sql SQL语句
     * @param fieldName 字段名
     * @param fieldValues 字段值
     */
    public static void orInString(Appendable sql, String fieldName, Object[] fieldValues)
    {
    	appendInString(sql, OR, fieldName, "in", fieldValues);
    }

    /**
     * 获得一个或逻辑的not in的查询条件，自动检测类型：or name not in (1,2,3)或者or name not in ('a','b')
     * @param sql SQL语句
     * @param fieldName 字段名
     * @param fieldValues 字段值
     */
    public static void orNotIn(Appendable sql, String fieldName, Object[] fieldValues)
    {
    	appendIn(sql, OR, fieldName, "not in", fieldValues);
    }
    
    /**
     * 获得一个或逻辑的not in数字的查询条件：or name not in (1,2,3)
     * @param sql SQL语句
     * @param fieldName 字段名
     * @param fieldValues 字段值
     */
    public static void orNotInNumber(Appendable sql, String fieldName, Object[] fieldValues)
    {
    	appendInNumber(sql, OR, fieldName, "not in", fieldValues);
    }
    
    /**
     * 获得一个或逻辑的not in字符串的查询条件：or name not in ('a','b')
     * @param sql SQL语句
     * @param fieldName 字段名
     * @param fieldValues 字段值
     */
    public static void orNotInString(Appendable sql, String fieldName, Object[] fieldValues)
    {
    	appendInString(sql, OR, fieldName, "not in", fieldValues);
    }
    
    /**
     * 创建数字比较条件的SQL语句
     * @param logic 逻辑操作符（and, or）
     * @param fieldName 字段名
     * @param operator 操作符（=, <>, >, >=, <, <=）
     * @param fieldValue 字段值
     * @param rejectedValue 被拒绝创建SQL语句的字段值
     * @return SQL语句
     */
    private static String create(String logic, String fieldName, String operator, Number fieldValue, Number rejectedValue)
    {
        StringBuilder sql = new StringBuilder();
        append(sql, logic, fieldName, operator, fieldValue, rejectedValue);
        return sql.toString();
    }
    
    /**
     * 创建除like条件之外的SQL语句
     * @param logic 逻辑操作符（and, or）
     * @param fieldName 字段名
     * @param operator 操作符（=, <>, >, >=, <, <=）
     * @param fieldValue 字段值
     * @return SQL语句
     */
    private static String create(String logic, String fieldName, String operator, String fieldValue)
    {
        StringBuilder sql = new StringBuilder();
        append(sql, logic, fieldName, operator, fieldValue);
        return sql.toString();
    }
    
    /**
     * 创建like条件的SQL语句
     * @param logic 逻辑操作符（and, or）
     * @param fieldName 字段名
     * @param operator 操作符（like, not like）
     * @param leftValue 字段值左边的添加值
     * @param fieldValue 字段值
     * @param rightValue 字段值右边的添加值
     * @return SQL语句
     */
    private static String createLike(String logic, String fieldName, String operator, String leftValue, String fieldValue, String rightValue)
    {
        StringBuilder sql = new StringBuilder();
        appendLike(sql, logic, fieldName, operator, leftValue, fieldValue, rightValue);
        return sql.toString();
    }

    /**
     * 创建in条件的SQL语句，自动检测数字类型或字符串类型。
     * @param logic 逻辑操作符（and, or）
     * @param fieldName 字段名
     * @param operator 操作符（in, not in）
     * @param fieldValues 字段值数组
     */
    private static String createIn(String logic, String fieldName, String operator, Object[] fieldValues)
    {
    	StringBuilder sql = new StringBuilder();
    	appendIn(sql, logic, fieldName, operator, fieldValues);
        return sql.toString();
    }

    /**
     * 以数字方式创建in条件的SQL语句
     * @param logic 逻辑操作符（and, or）
     * @param fieldName 字段名
     * @param operator 操作符（in, not in）
     * @param fieldValues 字段值数组
     */
    private static String createInNumber(String logic, String fieldName, String operator, Object[] fieldValues)
    {
    	StringBuilder sql = new StringBuilder();
    	appendInNumber(sql, logic, fieldName, operator, fieldValues);
        return sql.toString();
    }

    /**
     * 以字符串方式创建in条件的SQL语句
     * @param logic 逻辑操作符（and, or）
     * @param fieldName 字段名
     * @param operator 操作符（in, not in）
     * @param fieldValues 字段值数组
     */
    private static String createInString(String logic, String fieldName, String operator, Object[] fieldValues)
    {
    	StringBuilder sql = new StringBuilder();
    	appendInString(sql, logic, fieldName, operator, fieldValues);
        return sql.toString();
    }

    /**
     * 添加SQL语句
     * @param sql SQL缓冲区
     * @param logic 逻辑操作符（and, or）
     * @param fieldName 字段名
     * @param operator 操作符（=, <>, >, >=, <, <=）
     * @param fieldValue 字段值
     * @param rejectedValue 被拒绝添加SQL语句的字段值
     */
    private static void append(Appendable sql, String logic, String fieldName, String operator, Number fieldValue, Number rejectedValue)
    {
        if (fieldValue != null && !fieldValue.equals(rejectedValue))
        {
            try
            {
                sql.append(logic).append(fieldName).append(" ").append(operator).append(" ")
                        .append(fieldValue.toString());
            }
            catch (IOException e)
            {
                // 此处不需要处理IO异常
            }
        }
    }
    
    /**
     * 添加除like条件之外的SQL语句
     * @param sql SQL缓冲区
     * @param logic 逻辑操作符（and, or）
     * @param fieldName 字段名
     * @param operator 操作符（=, <>, >, >=, <, <=）
     * @param fieldValue 字段值
     */
    private static void append(Appendable sql, String logic, String fieldName, String operator, String fieldValue)
    {
        if (fieldValue != null && fieldValue.length() > 0)
        {
            try
            {
                sql.append(logic).append(fieldName).append(" ").append(operator).append(" '")
                        .append(encode(fieldValue)).append("'");
            }
            catch (IOException e)
            {
                // 此处不需要处理IO异常
            }
        }
    }

    /**
     * 添加like条件的SQL语句
     * @param sql SQL缓冲区
     * @param logic 逻辑操作符（and, or）
     * @param fieldName 字段名
     * @param operator 操作符（like, not like）
     * @param leftValue 字段值左边的添加值
     * @param fieldValue 字段值
     * @param rightValue 字段值右边的添加值
     */
    private static void appendLike(Appendable sql, String logic, String fieldName, String operator, String leftValue, String fieldValue, String rightValue)
    {
        if (fieldValue != null && fieldValue.length() > 0)
        {
            try
            {
                sql.append(logic).append(fieldName).append(" ").append(operator).append(" '")
                        .append(leftValue).append(encodeLike(fieldValue)).append(rightValue)
                        .append("'");
            }
            catch (IOException e)
            {
                // 此处不需要处理IO异常
            }
        }
    }

    /**
     * 添加in条件的SQL语句，自动检测数字类型或字符串类型。
     * @param sql SQL缓冲区
     * @param logic 逻辑操作符（and, or）
     * @param fieldName 字段名
     * @param operator 操作符（in, not in）
     * @param fieldValues 字段值数组
     */
    private static void appendIn(Appendable sql, String logic, String fieldName, String operator, Object[] fieldValues)
    {
    	if (fieldValues == null || fieldValues.length == 0)
    	{
    		return;
    	}
    	
    	if (fieldValues instanceof Number[])
    	{
    		appendInNumber(sql, logic, fieldName, operator, (Number[]) fieldValues);
    	}
    	else
    	{
    		appendInString(sql, logic, fieldName, operator, fieldValues);
    	}
    }

    /**
     * 以数字方式添加in条件的SQL语句
     * @param sql SQL缓冲区
     * @param logic 逻辑操作符（and, or）
     * @param fieldName 字段名
     * @param operator 操作符（in, not in）
     * @param fieldValues 字段值数组
     */
    private static void appendInNumber(Appendable sql, String logic, String fieldName, String operator, Object[] fieldValues)
    {
    	if (fieldValues != null && fieldValues.length > 0)
    	{
    		try
            {
                sql.append(logic).append(fieldName).append(" ").append(operator).append("(").append(fieldValues[0].toString());
                for (int i = 1; i < fieldValues.length; i++)
                {
                	sql.append(',').append(fieldValues[i].toString());
                }
                sql.append(")");
            }
            catch (IOException e)
            {
                // 此处不需要处理IO异常
            }
    	}
    }

    /**
     * 以字符串方式添加in条件的SQL语句
     * @param sql SQL缓冲区
     * @param logic 逻辑操作符（and, or）
     * @param fieldName 字段名
     * @param operator 操作符（in, not in）
     * @param fieldValues 字段值数组
     */
    private static void appendInString(Appendable sql, String logic, String fieldName, String operator, Object[] fieldValues)
    {
    	if (fieldValues != null && fieldValues.length > 0)
    	{
    		try
            {
                sql.append(logic).append(fieldName).append(" ").append(operator).append("('").append(fieldValues[0].toString()).append("'");
                for (int i = 1; i < fieldValues.length; i++)
                {
                	sql.append(",'").append(encode(fieldValues[i].toString())).append("'");
                }
                sql.append(")");
            }
            catch (IOException e)
            {
                // 此处不需要处理IO异常
            }
    	}
    }
    
    /**
     * <p>针对除like条件之外的字段值进行编码，以使拼接的SQL语句可以正确执行，同时防止SQL注入。</p>
     * @param s 需要被编码的对象
     * @return 编码后的字符串
     */
    public static String encode(Object s)
    {
        return s.toString().replace("\\", "\\\\").replace("'", "\\'");
    }

    /**
     * <p>针对like条件的字段值进行编码，以使拼接的SQL语句可以正确执行，同时防止SQL注入。</p>
     * @param s 需要被编码的对象
     * @return 编码后的字符串
     */
    public static String encodeLike(Object s)
    {
        return s.toString().replace("\\", "\\\\\\\\").replace("'", "\\'").replace("%", "\\%").replace("_", "\\_");
    }
    
    /**
     * <p>针对PreparedStatement语句参数的like条件的字段值进行编码，以使拼接的SQL语句可以正确执行，同时防止SQL注入。</p>
     * @param s 需要被编码的对象
     * @return 编码后的字符串
     */
    public static String encodePreparedLike(Object s)
    {
        return s.toString().replace("\\", "\\\\").replace("'", "\\'").replace("%", "\\%").replace("_", "\\_");
    }

    /**
     * <p>把对象数组每一项作为SQL中带有单引号的字符串格式连接成一串字符，可用于SQL中的in条件语句。</p>
     * 例如：对象数组为：{ "123", "abc", "qqq" }，则结果为 "'123','abc','qqq'"
     * @param objs 对象数组
     * @return 拼接后的字符串
     */
    public static String joinAsString(Object[] objs)
    {
        if (objs.length == 0)
        {
            return "";
        }
        
        StringBuilder s = new StringBuilder();
        s.append("'").append(encode(objs[0])).append("'");
        for (int i = 1; i < objs.length; i++)
        {
            s.append(",'").append(encode(objs[i])).append("'");
        }
        return s.toString();
    }

    /**
     * <p>把对象数组每一项作为SQL中的数字格式连接成一串字符，可用于SQL中的in条件语句。</p>
     * 例如：对象数组为：{ "123", "777", "100" }，则结果为 "123,777,100"
     * @param objs 对象数组
     * @return 拼接后的字符串
     */
    public static String joinAsNumber(Object[] objs)
    {
        if (objs.length == 0)
        {
            return "";
        }
        
        StringBuilder s = new StringBuilder();
        s.append(objs[0]);
        for (int i = 1; i < objs.length; i++)
        {
            s.append(",").append(objs[i]);
        }
        return s.toString();
    }

    /**
     * <p>把对象列表每一项作为SQL中带有单引号的字符串格式连接成一串字符，可用于SQL中的in条件语句。</p>
     * 例如：对象列表为：{ "123", "abc", "qqq" }，则结果为 "'123','abc','qqq'"
     * @param list 对象列表
     * @return 拼接后的字符串
     */
    public static String joinAsString(List<?> list)
    {
        if (list.size() == 0)
        {
            return "";
        }
        
        StringBuilder s = new StringBuilder();
        s.append("'").append(encode(list.get(0))).append("'");
        for (int i = 1, ii = list.size(); i < ii; i++)
        {
            s.append(",'").append(encode(list.get(i))).append("'");
        }
        return s.toString();
    }

    /**
     * <p>把对象列表每一项作为SQL中的数字格式连接成一串字符，可用于SQL中的in条件语句。</p>
     * 例如：对象列表为：{ "123", "777", "100" }，则结果为 "123,777,100"
     * @param list 对象列表
     * @return 拼接后的字符串
     */
    public static String joinAsNumber(List<?> list)
    {
        if (list.size() == 0)
        {
            return "";
        }
        
        StringBuilder s = new StringBuilder();
        s.append(list.get(0));
        for (int i = 1, ii = list.size(); i < ii; i++)
        {
            s.append(",").append(list.get(i));
        }
        return s.toString();
    }

    /**
     * 将预编译SQL语句和参数组合成完整的SQL语句
     * @param sql 预编译SQL语句
     * @param params 预编译SQL参数
     * @return 返回结合了参数的SQL语句
     */
    public static String fromPstmt(String sql, Object... params)
    {
    	if (params == null || params.length == 0)
        {
            return sql;
        }
        
        boolean isString = false;
        int start = 0;
        int paramIndex = 0;
        StringBuilder result = new StringBuilder(sql.length() + getParamsSize(params));
        
        for (int i = 0; i < sql.length(); i++)
        {
            switch (sql.charAt(i))
            {
            case '\\':
                i++;
                break;
            case '\'':
                isString = !isString;
                break;
            case '?':
                if (!isString)
                {
                    String partSql = sql.substring(start, i);
                    Object param = params[paramIndex++];
                    
                    if (paramIndex > params.length)
                        return "SQL语句参数个数不匹配：" + sql;
                    
                    result.append(partSql);
                    
                    if (param == null)
                        result.append("null");
                    else if (param instanceof Number)
                        result.append(param);
                    else
                        result.append("'").append(SQL.encode(param)).append("'");
                    
                    start = i + 1;
                }
                break;
            }
        }
        
        if (isString)
        {
            return "无法解析SQL语句: " + sql;
        }
        
        result.append(sql.substring(start));
        
        return result.toString();
    }

    /**
     * 获得预编译SQL参数的总长度
     * @param params SQL参数
     * @return 预编译SQL参数的总长度
     */
    private static int getParamsSize(Object[] params)
    {
        int size = 0;
        for (Object param : params)
        {
            if (param == null)
            {
                size += 3;// =4-1，去掉被替换的问号。
            }
            else
            {
                size += (param.toString().length() + 1);//=2-1，去掉被替换的问号，加上两个单引号。
            }
        }
        return size;
    }
    
    /**
     * 示例
     * @param args 
     */
    public static void main(String[] args)
    {
    }
}
