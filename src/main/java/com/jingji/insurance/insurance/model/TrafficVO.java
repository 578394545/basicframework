package com.jingji.insurance.insurance.model;

import java.io.Serializable;

/**
 * 交通意外险vo
 * @author Soar
 * @date 2018/5/10
 */
public class TrafficVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String quota; //保额（万元/人）.
    private String premium; //保费.
    private String item; //项目.
    private String remark; //说明.
    /**
     * 设定保额（万元/人）. <br />
     *
     * @param quota 保额（万元/人）
     */
    public void setQuota(String quota) {

        this.quota = quota;
    }

    /**
     * 取得保额（万元/人）. <br />
     *
     * @return 保额（万元/人）
     */
    public String getQuota() {

        return quota;
    }

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
     * 设定项目. <br />
     *
     * @param item 项目
     */
    public void setItem(String item) {

        this.item = item;
    }

    /**
     * 取得项目. <br />
     *
     * @return 项目
     */
    public String getItem() {

        return item;
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
