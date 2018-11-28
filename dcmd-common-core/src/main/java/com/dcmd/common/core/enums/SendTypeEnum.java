package com.dcmd.common.core.enums;

/**
 * 下发类型
 * @author liaoqisheng
 *
 */
public enum SendTypeEnum {
	
	PLAN("1","分时计划"),
	REPORT("2","报表核对"),
	TESTCASE("3","案例"),
	OPERATE("4","运营指令");
	
	private String value;
	
	private String description;
	
	private SendTypeEnum(String value, String description) {
		
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
