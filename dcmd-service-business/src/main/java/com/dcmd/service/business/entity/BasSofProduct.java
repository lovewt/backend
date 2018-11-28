package com.dcmd.service.business.entity;

import java.io.Serializable;

/**
 * @author 
 */
public class BasSofProduct implements Serializable {
    /**
     * 软件产品编号
     */
    private Integer softwareNum;

    /**
     * 软件系统代码
     */
    private String softwareSysCode;

    /**
     * 软件产品名称
     */
    private String softwareName;

    /**
     * 软件产品代码
     */
    private String softwareCode;

    /**
     * 类型
     */
    private String type;

    /**
     * 核心软件标志
     */
    private String coreSoftwareMark;

    /**
     * 状态
     */
    private String status;

    /**
     * 上线日期
     */
    private String launchDate;

    private String offlineDate;

    /**
     * 所属部门
     */
    private String dept;

    private String businessOwner;

    /**
     * 产品负责人
     */
    private String productLeader;

    /**
     * 需求负责人
     */
    private String baPrimary;

    private String baSecondary;

    private String saPrimary;

    private String saSecondary;

    /**
     * 测试负责人
     */
    private String testLeader;

    /**
     * 服务负责人
     */
    private String servicePrimary;

    private String serviceSecondary;

    /**
     * 项目管理负责人
     */
    private String projectLeader;

    private String description;

    private String customerSysName;

    private String businessRep;

    private String procureMethod;

    private String devMethod;

    private String cooperationPartner;

    private String acLevel;

    private String drLevel;

    private String infraId;

    /**
     * 复核状态，0表示复核成功，1表示待复核
     */
    private String state;

    private static final long serialVersionUID = 1L;

    public Integer getSoftwareNum() {
        return softwareNum;
    }

    public void setSoftwareNum(Integer softwareNum) {
        this.softwareNum = softwareNum;
    }

    public String getSoftwareSysCode() {
        return softwareSysCode;
    }

    public void setSoftwareSysCode(String softwareSysCode) {
        this.softwareSysCode = softwareSysCode;
    }

    public String getSoftwareName() {
        return softwareName;
    }

    public void setSoftwareName(String softwareName) {
        this.softwareName = softwareName;
    }

    public String getSoftwareCode() {
        return softwareCode;
    }

    public void setSoftwareCode(String softwareCode) {
        this.softwareCode = softwareCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCoreSoftwareMark() {
        return coreSoftwareMark;
    }

    public void setCoreSoftwareMark(String coreSoftwareMark) {
        this.coreSoftwareMark = coreSoftwareMark;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(String launchDate) {
        this.launchDate = launchDate;
    }

    public String getOfflineDate() {
        return offlineDate;
    }

    public void setOfflineDate(String offlineDate) {
        this.offlineDate = offlineDate;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getBusinessOwner() {
        return businessOwner;
    }

    public void setBusinessOwner(String businessOwner) {
        this.businessOwner = businessOwner;
    }

    public String getProductLeader() {
        return productLeader;
    }

    public void setProductLeader(String productLeader) {
        this.productLeader = productLeader;
    }

    public String getBaPrimary() {
        return baPrimary;
    }

    public void setBaPrimary(String baPrimary) {
        this.baPrimary = baPrimary;
    }

    public String getBaSecondary() {
        return baSecondary;
    }

    public void setBaSecondary(String baSecondary) {
        this.baSecondary = baSecondary;
    }

    public String getSaPrimary() {
        return saPrimary;
    }

    public void setSaPrimary(String saPrimary) {
        this.saPrimary = saPrimary;
    }

    public String getSaSecondary() {
        return saSecondary;
    }

    public void setSaSecondary(String saSecondary) {
        this.saSecondary = saSecondary;
    }

    public String getTestLeader() {
        return testLeader;
    }

    public void setTestLeader(String testLeader) {
        this.testLeader = testLeader;
    }

    public String getServicePrimary() {
        return servicePrimary;
    }

    public void setServicePrimary(String servicePrimary) {
        this.servicePrimary = servicePrimary;
    }

    public String getServiceSecondary() {
        return serviceSecondary;
    }

    public void setServiceSecondary(String serviceSecondary) {
        this.serviceSecondary = serviceSecondary;
    }

    public String getProjectLeader() {
        return projectLeader;
    }

    public void setProjectLeader(String projectLeader) {
        this.projectLeader = projectLeader;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCustomerSysName() {
        return customerSysName;
    }

    public void setCustomerSysName(String customerSysName) {
        this.customerSysName = customerSysName;
    }

    public String getBusinessRep() {
        return businessRep;
    }

    public void setBusinessRep(String businessRep) {
        this.businessRep = businessRep;
    }

    public String getProcureMethod() {
        return procureMethod;
    }

    public void setProcureMethod(String procureMethod) {
        this.procureMethod = procureMethod;
    }

    public String getDevMethod() {
        return devMethod;
    }

    public void setDevMethod(String devMethod) {
        this.devMethod = devMethod;
    }

    public String getCooperationPartner() {
        return cooperationPartner;
    }

    public void setCooperationPartner(String cooperationPartner) {
        this.cooperationPartner = cooperationPartner;
    }

    public String getAcLevel() {
        return acLevel;
    }

    public void setAcLevel(String acLevel) {
        this.acLevel = acLevel;
    }

    public String getDrLevel() {
        return drLevel;
    }

    public void setDrLevel(String drLevel) {
        this.drLevel = drLevel;
    }

    public String getInfraId() {
        return infraId;
    }

    public void setInfraId(String infraId) {
        this.infraId = infraId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", softwareNum=").append(softwareNum);
        sb.append(", softwareSysCode=").append(softwareSysCode);
        sb.append(", softwareName=").append(softwareName);
        sb.append(", softwareCode=").append(softwareCode);
        sb.append(", type=").append(type);
        sb.append(", coreSoftwareMark=").append(coreSoftwareMark);
        sb.append(", status=").append(status);
        sb.append(", launchDate=").append(launchDate);
        sb.append(", offlineDate=").append(offlineDate);
        sb.append(", dept=").append(dept);
        sb.append(", businessOwner=").append(businessOwner);
        sb.append(", productLeader=").append(productLeader);
        sb.append(", baPrimary=").append(baPrimary);
        sb.append(", baSecondary=").append(baSecondary);
        sb.append(", saPrimary=").append(saPrimary);
        sb.append(", saSecondary=").append(saSecondary);
        sb.append(", testLeader=").append(testLeader);
        sb.append(", servicePrimary=").append(servicePrimary);
        sb.append(", serviceSecondary=").append(serviceSecondary);
        sb.append(", projectLeader=").append(projectLeader);
        sb.append(", description=").append(description);
        sb.append(", customerSysName=").append(customerSysName);
        sb.append(", businessRep=").append(businessRep);
        sb.append(", procureMethod=").append(procureMethod);
        sb.append(", devMethod=").append(devMethod);
        sb.append(", cooperationPartner=").append(cooperationPartner);
        sb.append(", acLevel=").append(acLevel);
        sb.append(", drLevel=").append(drLevel);
        sb.append(", infraId=").append(infraId);
        sb.append(", state=").append(state);
        sb.append("]");
        return sb.toString();
    }

}