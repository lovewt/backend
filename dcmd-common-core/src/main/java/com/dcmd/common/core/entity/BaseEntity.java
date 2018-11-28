package com.dcmd.common.core.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.Length;

import com.dcmd.common.core.utils.DateUtils;


/**
 * 实体基类
 * @author yangyongdong
 *
 */
public class BaseEntity implements Serializable {
	
	private static final long serialVersionUID = 7190522492401710874L;

	/**
	 * 新增人ID
	 */
	@Length(max=10,message="新增人员ID不能大于10")
	@Column(name="create_id")
	private String createId;
	
	/**
	 * 新增人姓名
	 */
	@Length(max=40,message="新增人员姓名不能大于40")
	@Column(name="create_name")
	private String createName;
	
	/**
	 * 新增时间
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_datetime")
	private Date createDateTime;
	
	/**
	 * 修改人ID
	 */
	@Length(max=10,message="修改人ID不能大于10")
	@Column(name="update_id")
	private String updateId;
	
	/**
	 * 修改人姓名
	 */
	@Length(max=40,message="修改人姓名不能大于40")
	@Column(name="update_name")
	private String updateName;
	
	/**
	 * 修改时间
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_datetime")
	private Date updateDateTime;
	
	/**
	 * 备用1
	 */
	@Length(max=200,message="备用1不能大于200")
	@Column(name="reserve_String1")
	private String reserveString1;

	/**
	 * 备用2
	 */
	@Length(max=200,message="备用2不能大于200")
	@Column(name="reserve_String2")
	private String reserveString2;

	/**
	 * 备用3
	 */
	@Length(max=200,message="备用3不能大于200")
	@Column(name="reserve_String3")
	private String reserveString3;

	/**
	 * 备用4
	 */
	@Length(max=200,message="备用4不能大于200")
	@Column(name="reserve_String4")
	private String reserveString4;

	/**
	 * 备用5
	 */
	@Length(max=200,message="备用5不能大于200")
	@Column(name="reserve_String5")
	private String reserveString5;
	
	@Transient
	private String createDateTimeString;
	
	@Transient
	private String updateDateTimeString;
	
	/**
	 * 菜单类型：0执行，1管理
	 * 
	 */
	@Transient
	private String menuType;

	public String getCreateId() {
		return createId;
	}

	public void setCreateId(String createId) {
		this.createId = createId;
	}

	public String getCreateName() {
		return createName;
	}

	public void setCreateName(String createName) {
		this.createName = createName;
	}

	public Date getCreateDateTime() {
		return createDateTime;
	}

	public void setCreateDateTime(Date createDateTime) {
		this.createDateTime = createDateTime;
	}

	public String getUpdateId() {
		return updateId;
	}

	public void setUpdateId(String updateId) {
		this.updateId = updateId;
	}

	public String getUpdateName() {
		return updateName;
	}

	public void setUpdateName(String updateName) {
		this.updateName = updateName;
	}

	public Date getUpdateDateTime() {
		return updateDateTime;
	}

	public void setUpdateDateTime(Date updateDateTime) {
		this.updateDateTime = updateDateTime;
	}

	public String getReserveString1() {
		return reserveString1;
	}

	public void setReserveString1(String reserveString1) {
		this.reserveString1 = reserveString1;
	}

	public String getReserveString2() {
		return reserveString2;
	}

	public void setReserveString2(String reserveString2) {
		this.reserveString2 = reserveString2;
	}

	public String getReserveString3() {
		return reserveString3;
	}

	public void setReserveString3(String reserveString3) {
		this.reserveString3 = reserveString3;
	}

	public String getReserveString4() {
		return reserveString4;
	}

	public void setReserveString4(String reserveString4) {
		this.reserveString4 = reserveString4;
	}

	public String getReserveString5() {
		return reserveString5;
	}

	public void setReserveString5(String reserveString5) {
		this.reserveString5 = reserveString5;
	}

	public String getCreateDateTimeString() {
		
		return null==createDateTime?null:DateUtils.getTimeStampStr(createDateTime);
	}

	public void setCreateDateTimeString(String createDateTimeString) {
		this.createDateTimeString = createDateTimeString;
	}

	public String getUpdateDateTimeString() {
		
		return null==updateDateTime?null:DateUtils.getTimeStampStr(updateDateTime);
	}

	public void setUpdateDateTimeString(String updateDateTimeString) {
		this.updateDateTimeString = updateDateTimeString;
	}

	public String getMenuType() {
		return menuType;
	}

	public void setMenuType(String menuType) {
		this.menuType = menuType;
	}


}
