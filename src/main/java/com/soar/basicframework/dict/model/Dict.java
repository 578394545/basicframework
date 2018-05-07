package com.soar.basicframework.dict.model;

/**
 * 数据字典实体类
 * @author Soar
 * @date 2018/5/4
 */
public class Dict {
    public Dict(){}
    public Dict (Integer dType){
        this.setDType(dType);
    }
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
    private Integer dId;
    /**
     * 备注.
     */
    private String dRemark;

    /**
     * 类别（1001-默认日期；1002-证件类型；1003-与投保人关系；1004-投保方案）.
     */
    private Integer dType;
    /**
     * 序号.
     */
    private Integer dNo;
    /**
     * 设定类别（1001-默认日期；1002-证件类型；1003-与投保人关系）. <br />
     *
     * @param dType 类别（1001-默认日期；1002-证件类型；1003-与投保人关系）
     */
    public void setDType(Integer dType) {

        this.dType = dType;
    }

    /**
     * 取得类别（1001-默认日期；1002-证件类型；1003-与投保人关系）. <br />
     *
     * @return 类别（1001-默认日期；1002-证件类型；1003-与投保人关系）
     */
    public Integer getDType() {

        return dType;
    }

    /**
     * 设定序号. <br />
     *
     * @param dNo 序号
     */
    public void setDNo(Integer dNo) {

        this.dNo = dNo;
    }

    /**
     * 取得序号. <br />
     *
     * @return 序号
     */
    public Integer getDNo() {

        return dNo;
    }

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
    public void setDId(Integer dId) {

        this.dId = dId;
    }

    /**
     * 取得主键. <br />
     *
     * @return 主键
     */
    public Integer getDId() {

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
