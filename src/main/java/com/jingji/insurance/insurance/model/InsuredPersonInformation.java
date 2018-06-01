package com.jingji.insurance.insurance.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Date;

/**
 * 被投保人信息实体类
 * @author Soar
 * @date 2018/5/2
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class InsuredPersonInformation implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 投保人id.
     */
    private String pId; 
    /**
     * 与投保人关系（1-本人；2-配偶；3-子女；4-父母；5-其他）.
     */
    private Integer ipRelation;
    /**
     * 被投保人姓名.
     */
    private String iName; 
    /**
     * 被投保人证件类型（1-身份证；2-护照；3-户口簿；4-军人证件；5-来往港澳通行证；6-大陆居民往来台湾通行证；7-港澳居民来往内地通行证；8-台湾居民来往内地通行证；9-港澳居民身份证）.
     */
    private Integer iCardType; 
    /**
     * 被投保人证件号码.
     */
    private String iCard; 
    /**
     * 被投保人出生日期.
     */
    private Date iBirth; 
    /**
     * 主键.
     */
    private String iId; 
    /**
     * 创建时间.
     */
    private Date iCreateTime;

    /**
     * 身份证类型.
     */
    private String dValue;

    public String getdValue() {
        return dValue;
    }

    public void setdValue(String dValue) {
        this.dValue = dValue;
    }
    /**
     * 设定投保人id. <br />
     *
     * @param pId 投保人id
     */
    public void setPId(String pId) {

        this.pId = pId;
    }

    /**
     * 取得投保人id. <br />
     *
     * @return 投保人id
     */
    public String getPId() {

        return pId;
    }

    /**
     * 设定与投保人关系（1-本人；2-配偶；3-子女；4-父母；5-其他）. <br />
     *
     * @param ipRelation 与投保人关系（1-本人；2-配偶；3-子女；4-父母；5-其他）
     */
    public void setIpRelation(Integer ipRelation) {

        this.ipRelation = ipRelation;
    }

    /**
     * 取得与投保人关系（1-本人；2-配偶；3-子女；4-父母；5-其他）. <br />
     *
     * @return 与投保人关系（1-本人；2-配偶；3-子女；4-父母；5-其他）
     */
    public Integer getIpRelation() {

        return ipRelation;
    }

    /**
     * 设定被投保人姓名. <br />
     *
     * @param iName 被投保人姓名
     */
    public void setIName(String iName) {

        this.iName = iName;
    }

    /**
     * 取得被投保人姓名. <br />
     *
     * @return 被投保人姓名
     */
    public String getIName() {

        return iName;
    }

    /**
     * 设定被投保人证件类型（1-身份证；2-护照；3-户口簿；4-军人证件；5-来往港澳通行证；6-大陆居民往来台湾通行证；7-港澳居民来往内地通行证；8-台湾居民来往内地通行证；9-港澳居民身份证）. <br />
     *
     * @param iCardType 被投保人证件类型（1-身份证；2-护照；3-户口簿；4-军人证件；5-来往港澳通行证；6-大陆居民往来台湾通行证；7-港澳居民来往内地通行证；8-台湾居民来往内地通行证；9-港澳居民身份证）
     */
    public void setICardType(Integer iCardType) {

        this.iCardType = iCardType;
    }

    /**
     * 取得被投保人证件类型（1-身份证；2-护照；3-户口簿；4-军人证件；5-来往港澳通行证；6-大陆居民往来台湾通行证；7-港澳居民来往内地通行证；8-台湾居民来往内地通行证；9-港澳居民身份证）. <br />
     *
     * @return 被投保人证件类型（1-身份证；2-护照；3-户口簿；4-军人证件；5-来往港澳通行证；6-大陆居民往来台湾通行证；7-港澳居民来往内地通行证；8-台湾居民来往内地通行证；9-港澳居民身份证）
     */
    public Integer getICardType() {

        return iCardType;
    }

    /**
     * 设定被投保人证件号码. <br />
     *
     * @param iCard 被投保人证件号码
     */
    public void setICard(String iCard) {

        this.iCard = iCard;
    }

    /**
     * 取得被投保人证件号码. <br />
     *
     * @return 被投保人证件号码
     */
    public String getICard() {

        return iCard;
    }

    /**
     * 设定被投保人出生日期. <br />
     *
     * @param iBirth 被投保人出生日期
     */
    public void setIBirth(Date iBirth) {

        this.iBirth = iBirth;
    }

    /**
     * 取得被投保人出生日期. <br />
     *
     * @return 被投保人出生日期
     */
    public Date getIBirth() {

        return iBirth;
    }

    /**
     * 设定主键. <br />
     *
     * @param iId 主键
     */
    public void setIId(String iId) {

        this.iId = iId;
    }

    /**
     * 取得主键. <br />
     *
     * @return 主键
     */
    public String getIId() {

        return iId;
    }

    /**
     * 设定创建时间. <br />
     *
     * @param iCreateTime 创建时间
     */
    public void setICreateTime(Date iCreateTime) {

        this.iCreateTime = iCreateTime;
    }

    /**
     * 取得创建时间. <br />
     *
     * @return 创建时间
     */
    public Date getICreateTime() {

        return iCreateTime;
    }


}
