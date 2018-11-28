package com.dcmd.common.core.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="error_info")
@IdClass(ErrorInfoKey.class)
public class ErrorInfo extends BaseEntity {
	
	private static final long serialVersionUID = -3707227261849669280L;
	
	/**
	 * 机构单位号
	 */
	@Id
	@Length(max=50,message="机构单位号不能大于50")
	@Column(name="corporation_no")
	private String corporationNo;
	
	/**
	 * 项目编号
	 */
	@Id
	@Length(max=10,message="项目编号不能大于10")
	@Column(name="project_no")
	private String projectNo;
	
	/**
	 * 子项目编号
	 */
	@Id
	@Length(max=10,message="子项目编号不能大于10")
	@Column(name="sub_project_no")
	private String subProjectNo;
	
	/**
	 * 异常ID
	 */
	@Id
	@Length(max=10,message="异常ID不能大于10")
	@Column(name="error_id")
	private Integer errorId;
	
	/**
	 * 异常来源
	 */
	@Length(max=20,message="异常来源不能大于20")
	@Column(name="error_source")
	private String errorSource;
	
	/**
	 * 源ID
	 */
	@Length(max=10,message="源ID不能大于10")
	@Column(name="source_id")
	private String sourceId;
	
	/**
	 * 异常描述
	 */
	@Length(max=500,message="异常描述不能大于500")
	@Column(name="error_desc")
	private String errorDesc;
	
	/**
	 * 问题单号
	 */
	@Length(max=20,message="问题单号不能大于20")
	@Column(name="error_no")
	private String errorNo;
	
	/**
	 * 捕获时间
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="catch_datetime")
	private String catchDatetime;
	
	/**
	 * 恢复时间
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="recover_datetime")
	private String recoverDatetime;
	
	/**
	 * 报告人ID
	 */
	@Length(max=10,message="报告人ID不能大于10")
	@Column(name="report_user_id")
	private String reportUserId;
	
	/**
	 * 报告人姓名
	 */
	@Length(max=40,message="报告人姓名不能大于40")
	@Column(name="report_user_name")
	private String reportUserName;
	
	/**
	 * 跟踪人ID
	 */
	@Length(max=10,message="跟踪人ID不能大于10")
	@Column(name="track_user_id")
	private String trackUserId;
	
	/**
	 * 跟踪人姓名
	 */
	@Length(max=40,message="跟踪人姓名不能大于40")
	@Column(name="track_user_name")
	private String trackUserName;
	
	/**
	 * 有效标志
	 */
	@Length(max=1,message="有效标志不能大于1")
	@Column(name="valid_flag")
	private String validFlag;

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

	public Integer getErrorId() {
		return errorId;
	}

	public void setErrorId(Integer errorId) {
		this.errorId = errorId;
	}

	public String getErrorSource() {
		return errorSource;
	}

	public void setErrorSource(String errorSource) {
		this.errorSource = errorSource;
	}

	public String getSourceId() {
		return sourceId;
	}

	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	}

	public String getErrorDesc() {
		return errorDesc;
	}

	public void setErrorDesc(String errorDesc) {
		this.errorDesc = errorDesc;
	}

	public String getErrorNo() {
		return errorNo;
	}

	public void setErrorNo(String errorNo) {
		this.errorNo = errorNo;
	}

	public String getCatchDatetime() {
		return catchDatetime;
	}

	public void setCatchDatetime(String catchDatetime) {
		this.catchDatetime = catchDatetime;
	}

	public String getRecoverDatetime() {
		return recoverDatetime;
	}

	public void setRecoverDatetime(String recoverDatetime) {
		this.recoverDatetime = recoverDatetime;
	}

	public String getReportUserId() {
		return reportUserId;
	}

	public void setReportUserId(String reportUserId) {
		this.reportUserId = reportUserId;
	}

	public String getReportUserName() {
		return reportUserName;
	}

	public void setReportUserName(String reportUserName) {
		this.reportUserName = reportUserName;
	}

	public String getTrackUserId() {
		return trackUserId;
	}

	public void setTrackUserId(String trackUserId) {
		this.trackUserId = trackUserId;
	}

	public String getTrackUserName() {
		return trackUserName;
	}

	public void setTrackUserName(String trackUserName) {
		this.trackUserName = trackUserName;
	}

	public String getValidFlag() {
		return validFlag;
	}

	public void setValidFlag(String validFlag) {
		this.validFlag = validFlag;
	}
	
}
