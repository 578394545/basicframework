package com.soar.basicframework.employee.model;

/**
 * 员工信息实体类
 * @author soar
 * @date 2018/5/2
 */
public class Employee {
    /**
     * 员工工号.
     */
    private Integer number;

    /**
     * 员工姓名.
     */
    private String name;

    /**
     * 设定员工工号. <br />
     *
     * @param number 员工工号
     */
    public void setNumber(Integer number) {

        this.number = number;
    }

    /**
     * 取得员工工号. <br />
     *
     * @return 员工工号
     */
    public Integer getNumber() {

        return number;
    }

    /**
     * 设定员工姓名. <br />
     *
     * @param name 员工姓名
     */
    public void setName(String name) {

        this.name = name;
    }

    /**
     * 取得员工姓名. <br />
     *
     * @return 员工姓名
     */
    public String getName() {

        return name;
    }

}
