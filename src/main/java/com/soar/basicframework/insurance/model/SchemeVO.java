package com.soar.basicframework.insurance.model;

import java.io.Serializable;
import java.util.List;

/**
 * 投保方案对外实体类VO
 * @author Soar
 * @date 2018/5/10
 */
public class SchemeVO implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
     * 方案名称.
     */
    private String sName;

    /**
     * 方案价格及购买限制
     */
    private List<SchemePriceVO> schemePrices;

    /**
     * 方案详情
     */
    private List<SchemeDetailVO> schemeDetailVOs;

    public List<SchemeDetailVO> getSchemeDetailVOs() {
        return schemeDetailVOs;
    }

    public void setSchemeDetailVOs(List<SchemeDetailVO> schemeDetailVOs) {
        this.schemeDetailVOs = schemeDetailVOs;
    }

    /**
     * 主键.
     */
    private Integer sId;

    /**
     * 获取方案价格及购买限制. <br />
     *
     * @return 方案价格及购买限制列表
     */
    public List<SchemePriceVO> getSchemePrices() {
        return schemePrices;
    }

    /**
     * 设定方案价格及购买限制列表. <br />
     *
     * @param schemePrices 方案价格及购买限制列表
     */
    public void setSchemePrices(List<SchemePriceVO> schemePrices) {
        this.schemePrices = schemePrices;
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
}
