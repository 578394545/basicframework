package com.jingji.insurance.dict.model;

import java.io.Serializable;

/**
 * @author Soar
 * @date 2018/5/7
 */
public class DictVO implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
     * 序号.
     */
    private Integer no;

    /**
     * 字典值.
     */
    private String value;

    /**
     * 设定字典值. <br />
     *
     * @param value 字典值
     */
    public void setValue(String value) {

        this.value = value;
    }

    /**
     * 取得字典值. <br />
     *
     * @return 字典值
     */
    public String getValue() {

        return value;
    }

    /**
     * 设定序号. <br />
     *
     * @param no 序号
     */
    public void setNo(Integer no) {

        this.no = no;
    }

    /**
     * 取得序号. <br />
     *
     * @return 序号
     */
    public Integer getNo() {

        return no;
    }


}
