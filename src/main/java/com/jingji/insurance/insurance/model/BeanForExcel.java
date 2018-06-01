package com.jingji.insurance.insurance.model;

import com.jingji.insurance.utils.ExcelVOAttribute;

import java.io.Serializable;

/**
 * 提供转换成excel的bean
 * @author Soar
 * @date 2018/6/1
 */
public class BeanForExcel implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * 投保人姓名.
     */
    @ExcelVOAttribute(name = "投保人姓名", column = "B", isExport = true)
    private String pName; 
    /**
     * 证件类型.
     */
    @ExcelVOAttribute(name = "证件类型", column = "C", isExport = true)
    private String pCardType; 
    /**
     * 证件号码.
     */
    @ExcelVOAttribute(name = "证件号码", column = "D", isExport = true)
    private String pCard; 
    /**
     * 手机号码.
     */
    @ExcelVOAttribute(name = "手机号码", column = "E", isExport = true)
    private String pPhone; 
    /**
     * 电子邮箱.
     */
    @ExcelVOAttribute(name = "电子邮箱", column = "F", isExport = true)
    private String pEmail; 
    /**
     * 投保方案.
     */
    @ExcelVOAttribute(name = "投保方案", column = "A", isExport = true)
    private String pItem;

    /**
     * 证件类型.
     */
    @ExcelVOAttribute(name = "证件类型", column = "H", isExport = true)
    private String iCardType; 
    /**
     * 证件号码.
     */
    @ExcelVOAttribute(name = "证件号码", column = "I", isExport = true)
    private String iCard; 
    /**
     * 出生日期.
     */
    @ExcelVOAttribute(name = "出生日期", column = "J", isExport = true)
    private String iBirth; 
    /**
     * 受益人.
     */
    @ExcelVOAttribute(name = "受益人", column = "K", isExport = true)
    private String beneficiary; 
    /**
     * 被保险人姓名.
     */
    @ExcelVOAttribute(name = "被保险人姓名", column = "G", isExport = true)
    private String iName; 
    /**
     * 保费（被投保人）.
     */
    @ExcelVOAttribute(name = "保费", column = "L", isExport = true)
    private String price; 
    /**
     * 设定证件类型. <br />
     *
     * @param iCardType 证件类型
     */
    public void setICardType(String iCardType) {

        this.iCardType = iCardType;
    }

    /**
     * 取得证件类型. <br />
     *
     * @return 证件类型
     */
    public String getICardType() {

        return iCardType;
    }

    /**
     * 设定证件号码. <br />
     *
     * @param iCard 证件号码
     */
    public void setICard(String iCard) {

        this.iCard = iCard;
    }

    /**
     * 取得证件号码. <br />
     *
     * @return 证件号码
     */
    public String getICard() {

        return iCard;
    }

    /**
     * 设定出生日期. <br />
     *
     * @param iBirth 出生日期
     */
    public void setIBirth(String iBirth) {

        this.iBirth = iBirth;
    }

    /**
     * 取得出生日期. <br />
     *
     * @return 出生日期
     */
    public String getIBirth() {

        return iBirth;
    }

    /**
     * 设定受益人. <br />
     *
     * @param beneficiary 受益人
     */
    public void setBeneficiary(String beneficiary) {

        this.beneficiary = beneficiary;
    }

    /**
     * 取得受益人. <br />
     *
     * @return 受益人
     */
    public String getBeneficiary() {

        return beneficiary;
    }

    /**
     * 设定被保险人姓名. <br />
     *
     * @param iName 被保险人姓名
     */
    public void setIName(String iName) {

        this.iName = iName;
    }

    /**
     * 取得被保险人姓名. <br />
     *
     * @return 被保险人姓名
     */
    public String getIName() {

        return iName;
    }

    /**
     * 设定保费（被投保人）. <br />
     *
     * @param price 保费（被投保人）
     */
    public void setPrice(String price) {

        this.price = price;
    }

    /**
     * 取得保费（被投保人）. <br />
     *
     * @return 保费（被投保人）
     */
    public String getPrice() {

        return price;
    }
    
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
     * 设定证件类型. <br />
     *
     * @param pCardType 证件类型
     */
    public void setPCardType(String pCardType) {

        this.pCardType = pCardType;
    }

    /**
     * 取得证件类型. <br />
     *
     * @return 证件类型
     */
    public String getPCardType() {

        return pCardType;
    }

    /**
     * 设定证件号码. <br />
     *
     * @param pCard 证件号码
     */
    public void setPCard(String pCard) {

        this.pCard = pCard;
    }

    /**
     * 取得证件号码. <br />
     *
     * @return 证件号码
     */
    public String getPCard() {

        return pCard;
    }

    /**
     * 设定手机号码. <br />
     *
     * @param pPhone 手机号码
     */
    public void setPPhone(String pPhone) {

        this.pPhone = pPhone;
    }

    /**
     * 取得手机号码. <br />
     *
     * @return 手机号码
     */
    public String getPPhone() {

        return pPhone;
    }

    /**
     * 设定电子邮箱. <br />
     *
     * @param pEmail 电子邮箱
     */
    public void setPEmail(String pEmail) {

        this.pEmail = pEmail;
    }

    /**
     * 取得电子邮箱. <br />
     *
     * @return 电子邮箱
     */
    public String getPEmail() {

        return pEmail;
    }

    /**
     * 设定投保方案. <br />
     *
     * @param pItem 投保方案
     */
    public void setPItem(String pItem) {

        this.pItem = pItem;
    }

    /**
     * 取得投保方案. <br />
     *
     * @return 投保方案
     */
    public String getPItem() {

        return pItem;
    }
    
}
