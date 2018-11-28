package com.dcmd.common.core.enums;


public enum MenuTypeEnum {
	
	EXECUTE("0","执行菜单"),
	MANAGE("1","管理菜单");
	
	private String value;
	
	private String description;
	
	private MenuTypeEnum(String value, String description) {
		
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
