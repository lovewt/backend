package com.dcmd.common.core;

/**
 * @ClassName DruidConfig
 * @Author lenovo
 * @Date 2018/10/31 16:30
 * @Version 1.0.0
 */
public class DruidConfig {

    public static final String LOGIN_USERNAME_KEY = "loginUsername";

    public static final String LOGIN_PASSWORD_KEY = "loginPassword";

    public static final String LOGIN_VALUE = "admin";

    public static final String LOGIN_URL = "/druid/*";

    public static final String SERVLET_KEY = "resetEnable";

    public static final String SERVLET_VALUE = "false";

    public static final String URL_PATTERN = "/*";

    public static final String FILTER_INIT_PARAMETER_KEY = "exclusions";

    public static final String FILTER_INIT_PARAMETER_VALUE = "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*";
}
