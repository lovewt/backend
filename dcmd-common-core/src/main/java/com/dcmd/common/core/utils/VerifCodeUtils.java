package com.dcmd.common.core.utils;

import java.util.Random;

public class VerifCodeUtils {
	
	private static final String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	
	/**
	 * 获取五位数据验证码
	 */
	public static String getVerifCode5(){
		StringBuilder sb = new StringBuilder(5);
		for(int i = 0;i < 5;i++) {
			char ch = str.charAt(new Random().nextInt(str.length()));
			sb.append(ch);
		}
		return sb.toString();
	}
	
	/**
	 * 获取指定长度的字符串
	 * @param length	长度
	 * @return
	 */
	public static String getVerifCode(int length){
		StringBuilder sb = new StringBuilder(length);
		for(int i = 0;i < length;i++) {
			char ch = str.charAt(new Random().nextInt(str.length()));
			sb.append(ch);
		}
		return sb.toString();
	}
}
