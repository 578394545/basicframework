package com.soar.basicframework.insurance.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 投保方案详情实体类
 * @author Soar
 * @date 2018/5/9
 */
public class SchemeDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 方案id.
     */
    private Integer sId; 
    /**
     * 项目id.
     */
    private Integer dId; 
    /**
     * 项目内容（json格式）.
     */
    private String sdContent; 
    /**
     * 主键.
     */
    private Integer sdId; 
    /**
     * 创建时间.
     */
    private Date sdCreateTime;

    /**
     * 保险项目名称.
     */
    private String dValue;

    private String sdRemark; //产品说明.
    /**
     * 设定产品说明. <br />
     *
     * @param sdRemark 产品说明
     */
    public void setSdRemark(String sdRemark) {

        this.sdRemark = sdRemark;
    }

    /**
     * 取得产品说明. <br />
     *
     * @return 产品说明
     */
    public String getSdRemark() {

        return sdRemark;
    }


    /**
     * 设定保险项目名称. <br />
     *
     * @param dValue 保险项目名称
     */
    public void setDValue(String dValue) {

        this.dValue = dValue;
    }

    /**
     * 取得保险项目名称. <br />
     *
     * @return 保险项目名称
     */
    public String getDValue() {

        return dValue;
    }

    /**
     * 设定方案id. <br />
     *
     * @param sId 方案id
     */
    public void setSId(Integer sId) {

        this.sId = sId;
    }

    /**
     * 取得方案id. <br />
     *
     * @return 方案id
     */
    public Integer getSId() {

        return sId;
    }

    /**
     * 设定项目id. <br />
     *
     * @param dId 项目id
     */
    public void setDId(Integer dId) {

        this.dId = dId;
    }

    /**
     * 取得项目id. <br />
     *
     * @return 项目id
     */
    public Integer getDId() {

        return dId;
    }

    /**
     * 设定项目内容（json格式）. <br />
     *
     * @param sdContent 项目内容（json格式）
     */
    public void setSdContent(String sdContent) {

        this.sdContent = sdContent;
    }

    /**
     * 取得项目内容（json格式）. <br />
     *
     * @return 项目内容（json格式）
     */
    public String getSdContent() {

        return sdContent;
    }

    /**
     * 设定主键. <br />
     *
     * @param sdId 主键
     */
    public void setSdId(Integer sdId) {

        this.sdId = sdId;
    }

    /**
     * 取得主键. <br />
     *
     * @return 主键
     */
    public Integer getSdId() {

        return sdId;
    }

    /**
     * 设定创建时间. <br />
     *
     * @param sdCreateTime 创建时间
     */
    public void setSdCreateTime(Date sdCreateTime) {

        this.sdCreateTime = sdCreateTime;
    }

    /**
     * 取得创建时间. <br />
     *
     * @return 创建时间
     */
    public Date getSdCreateTime() {

        return sdCreateTime;
    }

}
