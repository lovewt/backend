package com.dcmd.common.core.utils;

import java.security.SecureRandom;
import java.util.UUID;

import org.apache.catalina.SessionIdGenerator;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;


/**
 * 
 * Title      :  IdGen.java<br>
 * Description:  封装各种生成唯一性ID算法的工具类. <br>
 * Company    :  hiwan<br>
 * @author yangyongdong
 *
 */
@Component
@Lazy(false)
public class IdGen implements SessionIdGenerator {

	private static SecureRandom random = new SecureRandom();
	
	/**
	 * 封装JDK自带的UUID, 通过Random数字生成.
	 */
	public static String uuid() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	
	/**
	 * 使用SecureRandom随机生成Long. 
	 */
	public static Integer randomInt() {
		return Math.abs(random.nextInt());
	}

	@Override
	public String generateSessionId() {
		return null;
	}

	@Override
	public String generateSessionId(String arg0) {
		return null;
	}

	@Override
	public String getJvmRoute() {
		return null;
	}

	@Override
	public int getSessionIdLength() {
		return 0;
	}

	@Override
	public void setJvmRoute(String arg0) {
		
	}

	@Override
	public void setSessionIdLength(int arg0) {
		
	}

}
