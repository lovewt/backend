package com.dcmd.arch.api.entity;

import java.io.Serializable;

/**
 * @author 
 */
public class BasParameter implements Serializable {
    /**
     * ID
     */
    private Integer id;

    /**
     * 类型
     */
    private String type;

    /**
     * 父级参数
     */
    private String parent;

    /**
     * 键
     */
    private String key;

    /**
     * 值
     */
    private String value;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", type=").append(type);
        sb.append(", parent=").append(parent);
        sb.append(", key=").append(key);
        sb.append(", value=").append(value);
        sb.append("]");
        return sb.toString();
    }

}