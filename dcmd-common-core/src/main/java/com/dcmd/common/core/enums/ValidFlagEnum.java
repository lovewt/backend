package com.dcmd.common.core.enums;

/**
 * 有效标志
 * @author liaoqisheng
 *
 */
public enum ValidFlagEnum {
	
	INVALID("0","无效"),
	VALID("1","有效");
	
	private String value;
	
	private String description;
	
	private ValidFlagEnum(String value, String description) {
		
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
