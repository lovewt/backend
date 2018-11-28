package com.dcmd.common.core.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 流水产生类
 * @author master
 *
 */
public class SerialNumUtil {
	

	/**流水记录*/
	private static AtomicInteger WEBSERVER_NUMBER = new AtomicInteger();
	
	/**
	  * 
	  * @return
	  */
	 public static String getSerialNum(){
		 SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
			int num = WEBSERVER_NUMBER.incrementAndGet();
			if(num > 9999 ){
				WEBSERVER_NUMBER.set(0);
				num = 0;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			StringBuffer sb = new StringBuffer();
			sb.append(sf.format(new Date()));
			sb.append(String.format("%04d", num));
			return sb.toString();
	 }
	 
	 public static void main(String[] args) {
		System.out.println(getSerialNum());
	}
}
