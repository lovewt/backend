package com.dcmd.common.core.enums;

/**
 * 错误码
 * @author liaoqisheng
 *
 */
public enum ErrorCodeEnum {
	
	NORMAL("0000","正常"),
	ABNORMAL("0001","校验异常"),
	SERVER_EXP("0002","服务异常"),
	SESSION_TIMEOUT("0003","会话超时"),
	NO_PERMISSION("0004","无访问权限");
	
	
	private String value;
	
	private String description;
	
	private ErrorCodeEnum(String value, String description) {
		
		this.value = value;
		this.description = description;
	}

	public String getValue() {
		return value;
	}

	public String getDescription() {
		return description;
	}
	
	

}
