package com.jingji.insurance.insurance.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 投保方案详情实体类
 * @author Soar
 * @date 2018/5/9
 */
public class SchemeDetailContent implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 保费.
     */
    private String premium; 
    /**
     * 年龄段.
     */
    private String age; 
    /**
     * 说明.
     */
    private String remark; 
    /**
     * 设定保费. <br />
     *
     * @param premium 保费
     */
    public void setPremium(String premium) {

        this.premium = premium;
    }

    /**
     * 取得保费. <br />
     *
     * @return 保费
     */
    public String getPremium() {

        return premium;
    }

    /**
     * 设定年龄段. <br />
     *
     * @param age 年龄段
     */
    public void setAge(String age) {

        this.age = age;
    }

    /**
     * 取得年龄段. <br />
     *
     * @return 年龄段
     */
    public String getAge() {

        return age;
    }

    /**
     * 设定说明. <br />
     *
     * @param remark 说明
     */
    public void setRemark(String remark) {

        this.remark = remark;
    }

    /**
     * 取得说明. <br />
     *
     * @return 说明
     */
    public String getRemark() {

        return remark;
    }

}
