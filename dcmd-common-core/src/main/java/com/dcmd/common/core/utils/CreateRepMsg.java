package com.dcmd.common.core.utils;

import java.util.ArrayList;
import java.util.List;

import com.dcmd.common.core.entity.HeadEntity;
import com.dcmd.common.core.entity.MutBean;
import com.dcmd.common.core.entity.RepMsg;

public class CreateRepMsg {

	/**
	 * 获取返回报文头
	 * @param t
	 * @return
	 */
	public static <T> RepMsg<T> getRepMsg(T t){
		RepMsg<T> demandRepMsg = new RepMsg<T>();
		HeadEntity head = new HeadEntity();
		MutBean<T> mut = new MutBean<T>();
		//设置值
		List<T> list = new ArrayList<T>();
		list.add(t);
		mut.setListBody(list);
		
		demandRepMsg.setHead(head);
		demandRepMsg.setBody(mut);
		return demandRepMsg;
	}
	

}
