package com.dcmd.common.core.vo;

/**
 * @author 
 */
public class BasParameterVo{
    /**
     * ID
     */
    private Integer id;

    /**
     * 值
     */
    private String value;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "BasParameterVo{" +
                "id=" + id +
                ", value='" + value + '\'' +
                '}';
    }
}