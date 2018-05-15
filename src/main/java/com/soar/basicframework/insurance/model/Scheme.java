package com.soar.basicframework.insurance.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 投保方案实体类
 * @author Soar
 * @date 2018/5/9
 */
public class Scheme implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
     * 方案名称.
     */
    private String sName; 
    /**
     * 保费.
     */
    private String sPremium; 
    /**
     * 说明（可购份数）.
     */
    private String sRemark; 
    /**
     * 主键.
     */
    private Integer sId; 
    /**
     * 创建时间.
     */
    private Date sCreateTime;

    /**
     * 方案详情列表.
     */
    private List<SchemeDetail> schemeDetail;

    /**
     * 方案价格及购买限制
     */
    private List<SchemePrice> schemePrices;

    /**
     * 获取方案价格及购买限制. <br />
     *
     * @return 方案价格及购买限制列表
     */
    public List<SchemePrice> getSchemePrices() {
        return schemePrices;
    }

    /**
     * 设定方案价格及购买限制列表. <br />
     *
     * @param schemePrices 方案价格及购买限制列表
     */
    public void setSchemePrices(List<SchemePrice> schemePrices) {
        this.schemePrices = schemePrices;
    }

    /**
     * 取得方案详情列表. <br />
     *
     * @return 方案详情列表
     */
    public List<SchemeDetail> getSchemeDetail() {
        return schemeDetail;
    }
    /**
     * 设定方案详情. <br />
     *
     * @param schemeDetail 方案详情列表
     */
    public void setSchemeDetail(List<SchemeDetail> schemeDetail) {
        this.schemeDetail = schemeDetail;
    }

    /**
     * 设定方案名称. <br />
     *
     * @param sName 方案名称
     */
    public void setSName(String sName) {

        this.sName = sName;
    }

    /**
     * 取得方案名称. <br />
     *
     * @return 方案名称
     */
    public String getSName() {

        return sName;
    }

    /**
     * 设定保费. <br />
     *
     * @param sPremium 保费
     */
    public void setSPremium(String sPremium) {

        this.sPremium = sPremium;
    }

    /**
     * 取得保费. <br />
     *
     * @return 保费
     */
    public String getSPremium() {

        return sPremium;
    }

    /**
     * 设定说明（可购份数）. <br />
     *
     * @param sRemark 说明（可购份数）
     */
    public void setSRemark(String sRemark) {

        this.sRemark = sRemark;
    }

    /**
     * 取得说明（可购份数）. <br />
     *
     * @return 说明（可购份数）
     */
    public String getSRemark() {

        return sRemark;
    }

    /**
     * 设定主键. <br />
     *
     * @param sId 主键
     */
    public void setSId(Integer sId) {

        this.sId = sId;
    }

    /**
     * 取得主键. <br />
     *
     * @return 主键
     */
    public Integer getSId() {

        return sId;
    }

    /**
     * 设定创建时间. <br />
     *
     * @param sCreateTime 创建时间
     */
    public void setSCreateTime(Date sCreateTime) {

        this.sCreateTime = sCreateTime;
    }

    /**
     * 取得创建时间. <br />
     *
     * @return 创建时间
     */
    public Date getSCreateTime() {

        return sCreateTime;
    }

}
