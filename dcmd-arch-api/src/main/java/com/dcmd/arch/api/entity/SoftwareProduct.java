package com.dcmd.arch.api.entity;


/**
 * @author 
 */
public class SoftwareProduct{
    /**
     * 软件产品编号 softwareNum
     * :
     * "213"
     */
    private String softwareNum;
    //系统名称
    private String softwareSysName;

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
    private String coreSoftwareMarkName;

    /**
     * 状态
     */
    private String status;
    private String statusName;

    /**
     * 上线日期
     */
    private String launchDate;

    private String offlineDate;

    /**
     * 所属部门
     */
    private String dept;
    private String deptName;

    private String businessOwner;
    private String businessOwnerName;

    /**
     * 产品负责人
     */
    private String productLeader;
    private String productLeaderName;

    /**
     * 需求负责人
     */
    private String baPrimary;
    private String baPrimaryName;

    private String baSecondary;
    private String baSecondaryName;

    private String saPrimary;
    private String saPrimaryName;

    private String saSecondary;
    private String saSecondaryName;

    /**
     * 测试负责人
     */
    private String testLeader;
    private String testLeaderName;

    /**
     * 服务负责人
     */
    private String servicePrimary;
    private String servicePrimaryName;

    private String serviceSecondary;
    private String serviceSecondaryName;

    /**
     * 项目管理负责人
     */
    private String projectLeader;

    private String description;

    private String customerSysName;

    private String businessRep;

    private String procureMethod;
    private String procureMethodName;

    private String devMethod;
    private String devMethodName;

    private String cooperationPartner;

    private String acLevel;

    private String drLevel;

    private String infraId;

    /**
     * 复核状态，0表示复核成功，1表示待复核
     */
    private String state;
    private static final long serialVersionUID = 1L;

    public String getSoftwareNum() {
        return softwareNum;
    }

    public void setSoftwareNum(String softwareNum) {
        this.softwareNum = softwareNum;
    }

    public String getSoftwareSysName() {
        return softwareSysName;
    }

    public void setSoftwareSysName(String softwareSysName) {
        this.softwareSysName = softwareSysName;
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

    public String getCoreSoftwareMarkName() {
        return coreSoftwareMarkName;
    }

    public void setCoreSoftwareMarkName(String coreSoftwareMarkName) {
        this.coreSoftwareMarkName = coreSoftwareMarkName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
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

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getBusinessOwner() {
        return businessOwner;
    }

    public void setBusinessOwner(String businessOwner) {
        this.businessOwner = businessOwner;
    }

    public String getBusinessOwnerName() {
        return businessOwnerName;
    }

    public void setBusinessOwnerName(String businessOwnerName) {
        this.businessOwnerName = businessOwnerName;
    }

    public String getProductLeader() {
        return productLeader;
    }

    public void setProductLeader(String productLeader) {
        this.productLeader = productLeader;
    }

    public String getProductLeaderName() {
        return productLeaderName;
    }

    public void setProductLeaderName(String productLeaderName) {
        this.productLeaderName = productLeaderName;
    }

    public String getBaPrimary() {
        return baPrimary;
    }

    public void setBaPrimary(String baPrimary) {
        this.baPrimary = baPrimary;
    }

    public String getBaPrimaryName() {
        return baPrimaryName;
    }

    public void setBaPrimaryName(String baPrimaryName) {
        this.baPrimaryName = baPrimaryName;
    }

    public String getBaSecondary() {
        return baSecondary;
    }

    public void setBaSecondary(String baSecondary) {
        this.baSecondary = baSecondary;
    }

    public String getBaSecondaryName() {
        return baSecondaryName;
    }

    public void setBaSecondaryName(String baSecondaryName) {
        this.baSecondaryName = baSecondaryName;
    }

    public String getSaPrimary() {
        return saPrimary;
    }

    public void setSaPrimary(String saPrimary) {
        this.saPrimary = saPrimary;
    }

    public String getSaPrimaryName() {
        return saPrimaryName;
    }

    public void setSaPrimaryName(String saPrimaryName) {
        this.saPrimaryName = saPrimaryName;
    }

    public String getSaSecondary() {
        return saSecondary;
    }

    public void setSaSecondary(String saSecondary) {
        this.saSecondary = saSecondary;
    }

    public String getSaSecondaryName() {
        return saSecondaryName;
    }

    public void setSaSecondaryName(String saSecondaryName) {
        this.saSecondaryName = saSecondaryName;
    }

    public String getTestLeader() {
        return testLeader;
    }

    public void setTestLeader(String testLeader) {
        this.testLeader = testLeader;
    }

    public String getTestLeaderName() {
        return testLeaderName;
    }

    public void setTestLeaderName(String testLeaderName) {
        this.testLeaderName = testLeaderName;
    }

    public String getServicePrimary() {
        return servicePrimary;
    }

    public void setServicePrimary(String servicePrimary) {
        this.servicePrimary = servicePrimary;
    }

    public String getServicePrimaryName() {
        return servicePrimaryName;
    }

    public void setServicePrimaryName(String servicePrimaryName) {
        this.servicePrimaryName = servicePrimaryName;
    }

    public String getServiceSecondary() {
        return serviceSecondary;
    }

    public void setServiceSecondary(String serviceSecondary) {
        this.serviceSecondary = serviceSecondary;
    }

    public String getServiceSecondaryName() {
        return serviceSecondaryName;
    }

    public void setServiceSecondaryName(String serviceSecondaryName) {
        this.serviceSecondaryName = serviceSecondaryName;
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

    public String getProcureMethodName() {
        return procureMethodName;
    }

    public void setProcureMethodName(String procureMethodName) {
        this.procureMethodName = procureMethodName;
    }

    public String getDevMethod() {
        return devMethod;
    }

    public void setDevMethod(String devMethod) {
        this.devMethod = devMethod;
    }

    public String getDevMethodName() {
        return devMethodName;
    }

    public void setDevMethodName(String devMethodName) {
        this.devMethodName = devMethodName;
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
        return "SoftwareProduct{" +
                "softwareNum='" + softwareNum + '\'' +
                ", softwareSysName='" + softwareSysName + '\'' +
                ", softwareSysCode='" + softwareSysCode + '\'' +
                ", softwareName='" + softwareName + '\'' +
                ", softwareCode='" + softwareCode + '\'' +
                ", type='" + type + '\'' +
                ", coreSoftwareMark='" + coreSoftwareMark + '\'' +
                ", coreSoftwareMarkName='" + coreSoftwareMarkName + '\'' +
                ", status='" + status + '\'' +
                ", statusName='" + statusName + '\'' +
                ", launchDate='" + launchDate + '\'' +
                ", offlineDate='" + offlineDate + '\'' +
                ", dept='" + dept + '\'' +
                ", deptId='" + deptName + '\'' +
                ", businessOwner='" + businessOwner + '\'' +
                ", businessOwnerName='" + businessOwnerName + '\'' +
                ", productLeader='" + productLeader + '\'' +
                ", productLeaderName='" + productLeaderName + '\'' +
                ", baPrimary='" + baPrimary + '\'' +
                ", baPrimaryName='" + baPrimaryName + '\'' +
                ", baSecondary='" + baSecondary + '\'' +
                ", baSecondaryName='" + baSecondaryName + '\'' +
                ", saPrimary='" + saPrimary + '\'' +
                ", saPrimaryName='" + saPrimaryName + '\'' +
                ", saSecondary='" + saSecondary + '\'' +
                ", saSecondaryName='" + saSecondaryName + '\'' +
                ", testLeader='" + testLeader + '\'' +
                ", testLeaderName='" + testLeaderName + '\'' +
                ", servicePrimary='" + servicePrimary + '\'' +
                ", servicePrimaryName='" + servicePrimaryName + '\'' +
                ", serviceSecondary='" + serviceSecondary + '\'' +
                ", serviceSecondaryName='" + serviceSecondaryName + '\'' +
                ", projectLeader='" + projectLeader + '\'' +
                ", description='" + description + '\'' +
                ", customerSysName='" + customerSysName + '\'' +
                ", businessRep='" + businessRep + '\'' +
                ", procureMethod='" + procureMethod + '\'' +
                ", procureMethodName='" + procureMethodName + '\'' +
                ", devMethod='" + devMethod + '\'' +
                ", devMethodName='" + devMethodName + '\'' +
                ", cooperationPartner='" + cooperationPartner + '\'' +
                ", acLevel='" + acLevel + '\'' +
                ", drLevel='" + drLevel + '\'' +
                ", infraId='" + infraId + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}