package com.manager.server.enums;

/**
 * sysConf配置code
 * @author pengwei21684
 */
public enum  EnumSysConfCode {
    CAROUSEL("跑马灯","carousel");

    private String desc;
    private String code;

    private EnumSysConfCode(String desc, String code) {
        this.desc = desc;
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
