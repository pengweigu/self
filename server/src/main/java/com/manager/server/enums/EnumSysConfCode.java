package com.manager.server.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * sysConf配置code
 * @author pengwei21684
 */
public enum  EnumSysConfCode {
    //系统跑马灯配置code
    CAROUSEL("跑马灯","carousel");

    private String desc;
    private String code;

    private static Map<String,String> items;

    static {
        if(items == null){
            items = new HashMap<>();
        }
        EnumSysConfCode[] values = EnumSysConfCode.values();
        for (EnumSysConfCode value : values) {
            items.put(value.getCode(),value.getDesc());
        }
    }

    private EnumSysConfCode(String desc, String code) {
        this.desc = desc;
        this.code = code;
    }

    public static String getDescByCode(String code) {
        return items.get(code);
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
