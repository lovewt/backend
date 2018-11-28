package com.dcmd.common.core.utils;


/**
 * 常量定义
 */
public class AjaxResultUtil {
    private String message="操作成功";
    private Boolean success=true;

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    /**
     * 有进来都是false
     * @param message
     */
    public AjaxResultUtil(String message){
        this.message=message;
        this.success=false;
    }
    public AjaxResultUtil(){}
}
