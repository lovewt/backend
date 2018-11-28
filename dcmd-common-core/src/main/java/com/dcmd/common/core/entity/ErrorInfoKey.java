package com.dcmd.common.core.entity;

import java.io.Serializable;

public class ErrorInfoKey implements Serializable {

	private static final long serialVersionUID = -8213450079841900607L;

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
	
	/**
	 * 异常ID
	 */
	private String errorId;

	public ErrorInfoKey() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ErrorInfoKey(String corporationNo, String projectNo, String subProjectNo, String errorId) {
		super();
		this.corporationNo = corporationNo;
		this.projectNo = projectNo;
		this.subProjectNo = subProjectNo;
		this.errorId = errorId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((corporationNo == null) ? 0 : corporationNo.hashCode());
		result = prime * result + ((errorId == null) ? 0 : errorId.hashCode());
		result = prime * result + ((projectNo == null) ? 0 : projectNo.hashCode());
		result = prime * result + ((subProjectNo == null) ? 0 : subProjectNo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ErrorInfoKey other = (ErrorInfoKey) obj;
		if (corporationNo == null) {
			if (other.corporationNo != null)
				return false;
		} else if (!corporationNo.equals(other.corporationNo))
			return false;
		if (errorId == null) {
			if (other.errorId != null)
				return false;
		} else if (!errorId.equals(other.errorId))
			return false;
		if (projectNo == null) {
			if (other.projectNo != null)
				return false;
		} else if (!projectNo.equals(other.projectNo))
			return false;
		if (subProjectNo == null) {
			if (other.subProjectNo != null)
				return false;
		} else if (!subProjectNo.equals(other.subProjectNo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ErrorInfoKey [corporationNo=" + corporationNo + ", projectNo=" + projectNo + ", subProjectNo="
				+ subProjectNo + ", errorId=" + errorId + "]";
	}
}
