package com.manager.server.enums;

/**
 * 后台用户状态枚举
 * @author pengwei21684
 */
public enum EnumAdminUserStatus {
    //用户状态 正常
    NORMAL(1,"正常"),
    //用户状态 禁用
    PROHIBIT(2,"禁用");

    private Integer value;

    private String name;

    EnumAdminUserStatus(Integer value, String name) {
        this.value = value;
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }}
