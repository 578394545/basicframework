package com.soar.basicframework.dict.model;

/**
 * 数据字典实体类
 * @author Soar
 * @date 2018/5/4
 */
public class Dict {
    /**
     * 字典名.
     */
    private String dName; 
    /**
     * 字典值.
     */
    private String dValue; 
    /**
     * 主键.
     */
    private String dId; 
    /**
     * 备注.
     */
    private String dRemark; 
    /**
     * 设定字典名. <br />
     *
     * @param dName 字典名
     */
    public void setDName(String dName) {

        this.dName = dName;
    }

    /**
     * 取得字典名. <br />
     *
     * @return 字典名
     */
    public String getDName() {

        return dName;
    }

    /**
     * 设定字典值. <br />
     *
     * @param dValue 字典值
     */
    public void setDValue(String dValue) {

        this.dValue = dValue;
    }

    /**
     * 取得字典值. <br />
     *
     * @return 字典值
     */
    public String getDValue() {

        return dValue;
    }

    /**
     * 设定主键. <br />
     *
     * @param dId 主键
     */
    public void setDId(String dId) {

        this.dId = dId;
    }

    /**
     * 取得主键. <br />
     *
     * @return 主键
     */
    public String getDId() {

        return dId;
    }

    /**
     * 设定备注. <br />
     *
     * @param dRemark 备注
     */
    public void setDRemark(String dRemark) {

        this.dRemark = dRemark;
    }

    /**
     * 取得备注. <br />
     *
     * @return 备注
     */
    public String getDRemark() {

        return dRemark;
    }
}
