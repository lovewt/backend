package com.dcmd.common.core.entity;

public class RepMsg<T> {

	private HeadEntity head;//报文头
	
	private MutBean<T> body;//返回实体类List和其他参数

	public HeadEntity getHead() {
		return head;
	}

	public void setHead(HeadEntity head) {
		this.head = head;
	}

	public MutBean<T> getBody() {
		return body;
	}

	public void setBody(MutBean<T> body) {
		this.body = body;
	}
	

}
