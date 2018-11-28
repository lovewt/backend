package com.dcmd.common.core.entity;

/**
 * 报文头数据
 * @author yangyongdong
 *
 */
public class HeadEntity {
	/**
	 * 系统流水号
	 */
	private String sysSeqNo;
	
	/**
	 * 返回时间
	 */
	private String respTime;
	
	/**
	 * 错误码
	 */
	private String errorCode;
	
	/**
	 * 错误消息
	 */
	private String errorMsg;
	
	/**
	 * 机构单位号
	 */
	private String corporationNo;
	
	/**
	 * 项目编号
	 */

	private String projectNo;
	
	/**
	 * 子项目编号
	 */
	private String subProjectNo;

	public String getSysSeqNo() {
		return sysSeqNo;
	}

	public void setSysSeqNo(String sysSeqNo) {
		this.sysSeqNo = sysSeqNo;
	}

	public String getRespTime() {
		return respTime;
	}

	public void setRespTime(String respTime) {
		this.respTime = respTime;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getCorporationNo() {
		return corporationNo;
	}

	public void setCorporationNo(String corporationNo) {
		this.corporationNo = corporationNo;
	}

	public String getProjectNo() {
		return projectNo;
	}

	public void setProjectNo(String projectNo) {
		this.projectNo = projectNo;
	}

	public String getSubProjectNo() {
		return subProjectNo;
	}

	public void setSubProjectNo(String subProjectNo) {
		this.subProjectNo = subProjectNo;
	}
	
}
