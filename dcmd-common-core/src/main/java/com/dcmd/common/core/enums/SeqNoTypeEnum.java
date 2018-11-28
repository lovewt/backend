package com.dcmd.common.core.enums;

/**
 * 序列类型
 * @author liaoqisheng
 *
 */
public enum SeqNoTypeEnum {
	
	SEND_NO("1","下发编号"),
	ERROR_NO("2","异常ID"),
	OPERATE_TASK_ID("3","运营指令任务ID");
	
	private String value;
	
	private String description;
	
	private SeqNoTypeEnum(String value, String description) {
		
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
