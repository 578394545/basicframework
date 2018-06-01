package com.jingji.insurance.insurance.model;

import java.io.Serializable;

/**
 * 投保方案价格
 * @author Soar
 * @date 2018/5/10
 */
public class SchemePriceVO implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
     * 投保金额.
     */
    private String price;
    /**
     * 年龄描述.
     */
    private String age; 
    /**
     * 投保个数限制.
     */
    private Integer limit; 
    /**
     * 设定投保金额. <br />
     *
     * @param price 投保金额
     */
    public void setPrice(String price) {

        this.price = price;
    }

    /**
     * 取得投保金额. <br />
     *
     * @return 投保金额
     */
    public String getPrice() {

        return price;
    }

    /**
     * 设定年龄描述. <br />
     *
     * @param age 年龄描述
     */
    public void setAge(String age) {

        this.age = age;
    }

    /**
     * 取得年龄描述. <br />
     *
     * @return 年龄描述
     */
    public String getAge() {

        return age;
    }

    /**
     * 设定投保个数限制. <br />
     *
     * @param limit 投保个数限制
     */
    public void setLimit(Integer limit) {

        this.limit = limit;
    }

    /**
     * 取得投保个数限制. <br />
     *
     * @return 投保个数限制
     */
    public Integer getLimit() {

        return limit;
    }


}
