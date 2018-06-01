package com.jingji.insurance.user.model;

/**
 * user实体类demo
 * @author soar
 * @date 2018/4/21
 */
public class User {
    /**
     * 用户名.
     */
    private String userName;
    /**
     * 设定用户名. <br />
     *
     * @param userName 用户名
     */
    public void setUserName(String userName) {

        this.userName = userName;
    }

    /**
     * 取得用户名. <br />
     *
     * @return 用户名
     */
    public String getUserName() {

        return userName;
    }
}
