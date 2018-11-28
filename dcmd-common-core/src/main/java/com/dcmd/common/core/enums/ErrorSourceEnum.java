package com.dcmd.common.core.enums;

/**
 * 异常来源
 * @author liaoqisheng
 *
 */
public enum ErrorSourceEnum {

	TIME_PLAN("1","分时计划"),
	BUSINESS_CASE("2","业务案例"),
	OPERATE_CDM("3","运营指令"),
	REPORT_CHECK("4","报表核对"),
	OTHERS("5","分支行其它类指令");
	
	private String value;
	
	private String description;
	
	private ErrorSourceEnum(String value, String description) {
		
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
