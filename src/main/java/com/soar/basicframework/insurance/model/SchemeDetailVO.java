package com.soar.basicframework.insurance.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 投保方案详情实体类VO
 * @author Soar
 * @date 2018/5/10
 */
public class SchemeDetailVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 保险项目名称.
     */
    private String dValue;

    /**
     * 保险内容
     */
    private List<SchemeDetailContent> contentList;


    /**
     * 取得保险内容. <br />
     *
     * @return 保险项目内容
     */
    public List<SchemeDetailContent> getContentList() {
        return contentList;
    }
    /**
     * 设定保险内容. <br />
     *
     * @param contentList 设定保险内容
     */
    public void setContentList(List<SchemeDetailContent> contentList) {
        this.contentList = contentList;
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
}
