package com.dcmd.common.core.entity;

import java.util.List;

public class MutBean<T> {

	private List<T> listBody;//传入实体类
	
	private int pageNum;//当前页数
	
	private int pageSize;//每页条数
	
	private long total;//数据总条数


	public List<T> getListBody() {
		return listBody;
	}

	public void setListBody(List<T> listBody) {
		this.listBody = listBody;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

}
