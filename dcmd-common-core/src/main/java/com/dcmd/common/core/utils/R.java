package com.dcmd.common.core.utils;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Map链式编程工具类
 * Created by 1 on 2018/7/12.
 */
public class R{
    private String msg = "操作成功";
    private Integer code = 200;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    private Map<String, Object> map;

    public R() {}

    public static R build() {
        R instance = new R();
        instance.map = new HashMap<>();
        return instance;
    }

    public static R build(Map<String, Object> map) {
        R instance = new R();
        instance.map = map;
        return instance;
    }

    public static R buildLink() {
        R instance = new R();
        instance.map = new LinkedHashMap<>();
        return instance;
    }

    public R put(String key, Object value) {
        this.map.put(key, value);
        return this;
    }

    public R putAll(Map<String, Object> map) {
        this.map.putAll(map);
        return this;
    }

    public Map<String, Object> over() {
        return this.map;
    }
}
