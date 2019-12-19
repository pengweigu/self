package com.manager.server.response.admin;

import com.manager.server.response.BaseResult;

public class AdminBaseResult extends BaseResult {

    private String isSuccess;

    private String msgInfo;

    public String getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(String isSuccess) {
        this.isSuccess = isSuccess;
    }

    public String getMsgInfo() {
        return msgInfo;
    }

    public void setMsgInfo(String msgInfo) {
        this.msgInfo = msgInfo;
    }
}
