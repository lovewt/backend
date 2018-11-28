package com.dcmd.arch.api.entity;

import java.io.Serializable;

/**
 * @author 
 */
public class ProductView implements Serializable {
    /**
     * 接口服务编号
     */
    private Integer intServiceNum;

    /**
     * 调用接口服务编号
     */
    private Integer invokeIntServiceNum;

    /**
     * 状态：是否过期
     */
    private String state;

    /**
     * 有效日期
     */
    private String validDate;

    /**
     * 来源类型
     */
    private String originType;

    /**
     * 复核状态，1表示待复核，0表示复核完成
     */
    private String status;

    private static final long serialVersionUID = 1L;

    public Integer getIntServiceNum() {
        return intServiceNum;
    }

    public void setIntServiceNum(Integer intServiceNum) {
        this.intServiceNum = intServiceNum;
    }

    public Integer getInvokeIntServiceNum() {
        return invokeIntServiceNum;
    }

    public void setInvokeIntServiceNum(Integer invokeIntServiceNum) {
        this.invokeIntServiceNum = invokeIntServiceNum;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getValidDate() {
        return validDate;
    }

    public void setValidDate(String validDate) {
        this.validDate = validDate;
    }

    public String getOriginType() {
        return originType;
    }

    public void setOriginType(String originType) {
        this.originType = originType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", intServiceNum=").append(intServiceNum);
        sb.append(", invokeIntServiceNum=").append(invokeIntServiceNum);
        sb.append(", state=").append(state);
        sb.append(", validDate=").append(validDate);
        sb.append(", originType=").append(originType);
        sb.append(", status=").append(status);
        sb.append("]");
        return sb.toString();
    }
}