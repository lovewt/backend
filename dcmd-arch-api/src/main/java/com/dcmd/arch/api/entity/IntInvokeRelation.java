package com.dcmd.arch.api.entity;

/**
 * @author
 */
public class IntInvokeRelation {
    /**
     * 接口服务编号
     */
    private String intServiceNum;

    /**
     * 调用接口服务编号
     */
    private String invokeIntServiceNum;

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

    private String bIntNameCn;

    private String intNameEn;
    private String bSoftName;
    private String dIntName;
    private String bIntNameEn;
    private String dSoftName;


    private String stateName;


    private String statusName;

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    private static final long serialVersionUID = 1L;

    public String getIntServiceNum() {
        return intServiceNum;
    }

    public void setIntServiceNum(String intServiceNum) {
        this.intServiceNum = intServiceNum;
    }

    public String getInvokeIntServiceNum() {
        return invokeIntServiceNum;
    }

    public void setInvokeIntServiceNum(String invokeIntServiceNum) {
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

    public String getbIntNameCn() {
        return bIntNameCn;
    }

    public void setbIntNameCn(String bIntNameCn) {
        this.bIntNameCn = bIntNameCn;
    }

    public String getIntNameEn() {
        return intNameEn;
    }

    public void setIntNameEn(String intNameEn) {
        this.intNameEn = intNameEn;
    }

    public String getbSoftName() {
        return bSoftName;
    }

    public void setbSoftName(String bSoftName) {
        this.bSoftName = bSoftName;
    }

    public String getdIntName() {
        return dIntName;
    }

    public void setdIntName(String dIntName) {
        this.dIntName = dIntName;
    }

    public String getbIntNameEn() {
        return bIntNameEn;
    }

    public void setbIntNameEn(String bIntNameEn) {
        this.bIntNameEn = bIntNameEn;
    }

    public String getdSoftName() {
        return dSoftName;
    }

    public void setdSoftName(String dSoftName) {
        this.dSoftName = dSoftName;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }
}