package com.dcmd.common.core.utils;

import java.lang.reflect.Field;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dcmd.common.core.entity.HeadEntity;
import com.dcmd.common.core.entity.MutBean;
import com.dcmd.common.core.entity.RepMsg;
import com.dcmd.common.core.enums.ErrorCodeEnum;

/**
 * 公共消息报文头校验
 * @author liaoqisheng
 *
 * @param <T>
 */
public class ValidUtils<T> {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ValidUtils.class);
	
	/**
	 * 公共报文校验
	 * @param demandRepMsg 请求报文
	 * @param isValidBody 是否校验Body
	 * @return
	 */
	public static <T> boolean ValidCommHeader(RepMsg<T> demandRepMsg, boolean isValidBody) {
		
		LOGGER.info("公共报文校验开始");
		
		try {
			
			if(null==demandRepMsg) {
				
				LOGGER.info("公共报文请求参数：[demandRepMsg]为空");
				
				demandRepMsg = new RepMsg<T>();
				
				HeadEntity headEntity = new HeadEntity();
				headEntity.setErrorCode(ErrorCodeEnum.ABNORMAL.getValue());
				headEntity.setErrorMsg("公共报文为空");
				demandRepMsg.setHead(headEntity);
				return false;
			}
			
			//获取公共报文
			HeadEntity headEntity = demandRepMsg.getHead();
			//校验报文头
			if(null==headEntity) {
				
				LOGGER.info("公共报文头请求参数：[headEntity]为空");
				HeadEntity headEntityTemp = new HeadEntity();
				headEntityTemp.setErrorCode(ErrorCodeEnum.ABNORMAL.getValue());
				headEntityTemp.setErrorMsg("公共报文头为空");
				demandRepMsg.setHead(headEntityTemp);
				return false;
			}
			
			String corporationNo = headEntity.getCorporationNo();
			
			String projectNo = headEntity.getProjectNo();
			
			String subProjectNo = headEntity.getSubProjectNo();
			
			if(StringUtils.isBlank(corporationNo)) {
				
				LOGGER.info("公共报文头请求参数：机构单位号[corporationNo]为空");
				headEntity.setErrorCode(ErrorCodeEnum.ABNORMAL.getValue());
				headEntity.setErrorMsg("公共报文头请求参数：机构单位号[corporationNo]为空");
				demandRepMsg.setHead(headEntity);
				return false;
			}
			
			if(StringUtils.isBlank(projectNo)) {
							
				LOGGER.info("公共报文头请求参数：项目编号[projectNo]为空");
				headEntity.setErrorCode(ErrorCodeEnum.ABNORMAL.getValue());
				headEntity.setErrorMsg("公共报文头请求参数：项目编号[projectNo]为空");
				demandRepMsg.setHead(headEntity);
				return false;
			}
			
			if(StringUtils.isBlank(subProjectNo)) {
				
				LOGGER.info("公共报文头请求参数：子项目编号[subProjectNo]为空");
				headEntity.setErrorCode(ErrorCodeEnum.ABNORMAL.getValue());
				headEntity.setErrorMsg("公共报文头请求参数：子项目编号[subProjectNo]为空");
				demandRepMsg.setHead(headEntity);
				return false;
			}
			
			if(isValidBody) {
				
				//校验报文体
				MutBean<T> body = demandRepMsg.getBody();
				
				if(null==body) {
					
					LOGGER.info("公共报文体请求参数：[MutBean]为空");
					headEntity.setErrorCode(ErrorCodeEnum.ABNORMAL.getValue());
					headEntity.setErrorMsg("公共报文体为空");
					demandRepMsg.setHead(headEntity);
					return false;
				}
				
				
				List<T> bodyList = body.getListBody();
				
				if(CollectionUtils.isEmpty(bodyList)) {
					
					LOGGER.info("公共报文体请求参数：[listBody]为空");
					headEntity.setErrorCode(ErrorCodeEnum.ABNORMAL.getValue());
					headEntity.setErrorMsg("公共报文体为空");
					demandRepMsg.setHead(headEntity);
					return false;
				}
				
				for(T t : bodyList) {
					
					Field[] fields = t.getClass().getDeclaredFields();
					
					for(int i=0; i<fields.length; i++) {
						
						fields[i].setAccessible(true);
						String name = fields[i].getName();
						if(StringUtils.equals("corporationNo", name)) {
							
							String value = null==fields[i].get(t)?"":(String)fields[i].get(t);
							if(StringUtils.isBlank((String)value)) {
								
								LOGGER.info("公共报文体请求参数：机构单位号[corporationNo]为空");
								headEntity.setErrorCode(ErrorCodeEnum.ABNORMAL.getValue());
								headEntity.setErrorMsg("公共报文体请求参数：机构单位号[corporationNo]为空");
								demandRepMsg.setHead(headEntity);
								
								return false;
							}
						}
						if(StringUtils.equals("projectNo", name)) {
							
							String value = null==fields[i].get(t)?"":(String)fields[i].get(t);
							if(StringUtils.isBlank((String)value)) {
								
								LOGGER.info("公共报文体请求参数：项目编号[projectNo]为空");
								headEntity.setErrorCode(ErrorCodeEnum.ABNORMAL.getValue());
								headEntity.setErrorMsg("公共报文体请求参数：项目编号[projectNo]为空");
								demandRepMsg.setHead(headEntity);
								
								return false;
							}
						}
						if(StringUtils.equals("subProjectNo", name)) {
							
							String value = null==fields[i].get(t)?"":(String)fields[i].get(t);
							if(StringUtils.isBlank((String)value)) {
								
								LOGGER.info("公共报文体请求参数：子项目编号[subProjectNo]为空");
								headEntity.setErrorCode(ErrorCodeEnum.ABNORMAL.getValue());
								headEntity.setErrorMsg("公共报文体请求参数：子项目编号[subProjectNo]为空");
								demandRepMsg.setHead(headEntity);
								
								return false;
							}
						}
						
					}
					
				}
			}
			
		} catch (Exception e) {
			
			LOGGER.info("公共报文校验异常，异常原因：", e);
			demandRepMsg = new RepMsg<T>();
			HeadEntity headEntityTemp = new HeadEntity();
			headEntityTemp.setErrorCode(ErrorCodeEnum.SERVER_EXP.getValue());
			headEntityTemp.setErrorMsg("服务器异常，请联系管理员");
			demandRepMsg.setHead(headEntityTemp);
			return false;
		}
		
		LOGGER.info("公共报文校验结束");
		return true;
	}

}
