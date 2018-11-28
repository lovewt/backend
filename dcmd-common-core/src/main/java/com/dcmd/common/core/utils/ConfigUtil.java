package com.dcmd.common.core.utils;

import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ConfigUtil {

	private final static Logger logger = LoggerFactory.getLogger(ConfigUtil.class);
		
	static Properties pp;

	static{
		pp = new Properties();
		try {
			InputStream fps = ConfigUtil.class.getResourceAsStream("/config.properties");
			pp.load(fps);
			fps.close();
		} catch (Exception e) {
			logger.error("读取config.properties文件异常!");
			e.printStackTrace();
		}
	}
	public static String values(String key) {
		String value = pp.getProperty(key);
		if (value != null) {
			return value;
		} else {
			return null;
		}
	}
}