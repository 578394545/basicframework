package com.soar.basicframework.insurance.model;

import java.util.Date;

/**
 * 投保人信息实体类
 * @author soar
 * @date 2018/5/2
 */
public class PolicyholderInformation {
    /**
     * 投保人姓名.
     */
    private String pName;
    /**
     * 投保人证件类型（1-身份证；2-护照；3-户口簿；4-军人证件；5-来往港澳通行证；6-大陆居民往来台湾通行证；7-港澳居民来往内地通行证；8-台湾居民来往内地通行证；9-港澳居民身份证）.
     */
    private Integer pCardType;
    /**
     * 投保人证件号码.
     */
    private String pCard;
    /**
     * 投保人手机号码.
     */
    private Integer pPhone;
    /**
     * 投保人电子邮箱.
     */
    private String pEmail;
    /**
     * 主键.
     */
    private String pId; 
    /**
     * 创建时间.
     */
    private Date pCreateTime;
    /**
     * 设定投保人姓名. <br />
     *
     * @param pName 投保人姓名
     */
    public void setPName(String pName) {

        this.pName = pName;
    }

    /**
     * 取得投保人姓名. <br />
     *
     * @return 投保人姓名
     */
    public String getPName() {

        return pName;
    }

    /**
     * 设定投保人证件类型（1-身份证；2-护照；3-户口簿；4-军人证件；5-来往港澳通行证；6-大陆居民往来台湾通行证；7-港澳居民来往内地通行证；8-台湾居民来往内地通行证；9-港澳居民身份证）. <br />
     *
     * @param pCardType 投保人证件类型（1-身份证；2-护照；3-户口簿；4-军人证件；5-来往港澳通行证；6-大陆居民往来台湾通行证；7-港澳居民来往内地通行证；8-台湾居民来往内地通行证；9-港澳居民身份证）
     */
    public void setPCardType(Integer pCardType) {

        this.pCardType = pCardType;
    }

    /**
     * 取得投保人证件类型（1-身份证；2-护照；3-户口簿；4-军人证件；5-来往港澳通行证；6-大陆居民往来台湾通行证；7-港澳居民来往内地通行证；8-台湾居民来往内地通行证；9-港澳居民身份证）. <br />
     *
     * @return 投保人证件类型（1-身份证；2-护照；3-户口簿；4-军人证件；5-来往港澳通行证；6-大陆居民往来台湾通行证；7-港澳居民来往内地通行证；8-台湾居民来往内地通行证；9-港澳居民身份证）
     */
    public Integer getPCardType() {

        return pCardType;
    }

    /**
     * 设定投保人证件号码. <br />
     *
     * @param pCard 投保人证件号码
     */
    public void setPCard(String pCard) {

        this.pCard = pCard;
    }

    /**
     * 取得投保人证件号码. <br />
     *
     * @return 投保人证件号码
     */
    public String getPCard() {

        return pCard;
    }

    /**
     * 设定投保人手机号码. <br />
     *
     * @param pPhone 投保人手机号码
     */
    public void setPPhone(Integer pPhone) {

        this.pPhone = pPhone;
    }

    /**
     * 取得投保人手机号码. <br />
     *
     * @return 投保人手机号码
     */
    public Integer getPPhone() {

        return pPhone;
    }

    /**
     * 设定投保人电子邮箱. <br />
     *
     * @param pEmail 投保人电子邮箱
     */
    public void setPEmail(String pEmail) {

        this.pEmail = pEmail;
    }

    /**
     * 取得投保人电子邮箱. <br />
     *
     * @return 投保人电子邮箱
     */
    public String getPEmail() {

        return pEmail;
    }

    /**
     * 设定主键. <br />
     *
     * @param pId 主键
     */
    public void setPId(String pId) {

        this.pId = pId;
    }

    /**
     * 取得主键. <br />
     *
     * @return 主键
     */
    public String getPId() {

        return pId;
    }

    /**
     * 设定创建时间. <br />
     *
     * @param pCreateTime 创建时间
     */
    public void setPCreateTime(Date pCreateTime) {

        this.pCreateTime = pCreateTime;
    }

    /**
     * 取得创建时间. <br />
     *
     * @return 创建时间
     */
    public Date getPCreateTime() {

        return pCreateTime;
    }
}
