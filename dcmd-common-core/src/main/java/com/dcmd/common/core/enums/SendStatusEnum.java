package com.dcmd.common.core.enums;

/**
 * 下发状态
 * @author liaoqisheng
 *
 */
public enum SendStatusEnum {
	
	NO_SEND("0","未下发"),
	SENDED("1","已下发");
	
	private String value;
	
	private String description;
	
	private SendStatusEnum(String value, String description) {
		
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
