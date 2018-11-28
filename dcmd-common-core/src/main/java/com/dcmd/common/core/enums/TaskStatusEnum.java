package com.dcmd.common.core.enums;

/**
 * 任务状态
 * @author liaoqisheng
 *
 */
public enum TaskStatusEnum {
	
	NO_START("0","未开始"),
	WAIT_RECEIVE("1","待接收"),
	WAIT_EXC("2","待执行"),
	IN_EXC("3","执行中"),
	COMPLETE("4","完成"),
	EXCEPTION_1("5","异常"),
	EXCEPTION_2("9","异常");
	
	private String value;
	
	private String description;
	
	private TaskStatusEnum(String value, String description) {
		
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
