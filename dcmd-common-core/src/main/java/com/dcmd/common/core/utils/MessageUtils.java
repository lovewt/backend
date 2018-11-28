package com.dcmd.common.core.utils;

import java.util.Date;

import com.dcmd.common.core.entity.HeadEntity;



/**
 * 消息管理帮助
 * @author yangyongdong
 *
 */
public class MessageUtils {
	
	/**
	 * 失败
	 * @param head		报文头对象
	 * @param sysSeqNo	报文流水号
	 * @return
	 */
	public static HeadEntity failureMessage(HeadEntity head,String sysSeqNo,String msg){
		if(null == head) {
			head = new HeadEntity();
		}
		head.setSysSeqNo(sysSeqNo);
		head.setRespTime(DateUtils.formatDate(new Date(), "yyyyMMddHHmmssSSS"));
		head.setErrorCode("0001");
		head.setErrorMsg(msg);
		return head;
	}
	
	/**
	 * 成功
	 * @param head		报文头对象
	 * @param sysSeqNo	报文流水号
	 * @return
	 */
	public static HeadEntity successMessage(HeadEntity head,String sysSeqNo){
		if(null == head) {
			head = new HeadEntity();
		}
		head.setSysSeqNo(sysSeqNo);
		head.setRespTime(DateUtils.formatDate(new Date(), "yyyyMMddHHmmssSSS"));
		head.setErrorCode("0000");
		head.setErrorMsg("成功");
		return head;
	}

}
