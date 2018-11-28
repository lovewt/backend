package com.dcmd.common.core.utils;

/**
 * @JDK version used:       	1.8
 * @Modified By:            	<修改人中文名或拼音缩写>
 * @Modified Date:          	<修改日期，格式:YYYY年MM月DD日>
 * @Why & What is modified: 	<修改原因描述>
 * @create 2018-05-11 16:46
 **/
public class ErrorInfo extends  Exception{
    private Integer code = 500;
    private String message;

    public ErrorInfo(String message,Integer code) {
        this.code = code;
        this.message = message;
    }

    public ErrorInfo(){}


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ErrorInfo{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
