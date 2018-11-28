package com.dcmd.arch.api.entity;

public class InterfaceAnalysis {
    private String intServiceNum;
    private String softwareNum;
    private String state;
    private String intNameCn;
    private String intNameEn;
    private String description;
    private String url;
    private String reviewNumber;
    private String downlineDate;
    private String releaseDate;
    private String interfaceVersion;
    private String serviceFit;
    private String consumerFit;
    private String remark;
    private String softwareName;
    private String greatClass;
    private String greatClassName;
    private String stateName;
    private String softwareSysCode;

    public String getSoftwareSysCode() {
        return softwareSysCode;
    }

    public void setSoftwareSysCode(String softwareSysCode) {
        this.softwareSysCode = softwareSysCode;
    }

    public String getGreatClass() {
        return greatClass;
    }

    public void setGreatClass(String greatClass) {
        this.greatClass = greatClass;
    }

    public String getIntServiceNum() {
        return intServiceNum;
    }

    public void setIntServiceNum(String intServiceNum) {
        this.intServiceNum = intServiceNum;
    }

    public String getSoftwareNum() {
        return softwareNum;
    }

    public void setSoftwareNum(String softwareNum) {
        this.softwareNum = softwareNum;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getIntNameCn() {
        return intNameCn;
    }

    public void setIntNameCn(String intNameCn) {
        this.intNameCn = intNameCn;
    }

    public String getIntNameEn() {
        return intNameEn;
    }

    public void setIntNameEn(String intNameEn) {
        this.intNameEn = intNameEn;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getReviewNumber() {
        return reviewNumber;
    }

    public void setReviewNumber(String reviewNumber) {
        this.reviewNumber = reviewNumber;
    }

    public String getDownlineDate() {
        return downlineDate;
    }

    public void setDownlineDate(String downlineDate) {
        this.downlineDate = downlineDate;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getInterfaceVersion() {
        return interfaceVersion;
    }

    public void setInterfaceVersion(String interfaceVersion) {
        this.interfaceVersion = interfaceVersion;
    }

    public String getServiceFit() {
        return serviceFit;
    }

    public void setServiceFit(String serviceFit) {
        this.serviceFit = serviceFit;
    }

    public String getConsumerFit() {
        return consumerFit;
    }

    public void setConsumerFit(String consumerFit) {
        this.consumerFit = consumerFit;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getSoftwareName() {
        return softwareName;
    }

    public void setSoftwareName(String softwareName) {
        this.softwareName = softwareName;
    }

    public String getGreatClassName() {
        return greatClassName;
    }

    public void setGreatClassName(String greatClassName) {
        this.greatClassName = greatClassName;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", softwareName=").append(softwareName);
        sb.append(", greatClassName=").append(greatClassName);
        sb.append(", stateName=").append(stateName);
        sb.append(", intNameCn=").append(intNameCn);
        sb.append(", intNameEn=").append(intNameEn);
        sb.append(", description=").append(description);
        sb.append(", url=").append(url);
        sb.append(", reviewNumber=").append(reviewNumber);
        sb.append(", downlineDate=").append(downlineDate);
        sb.append(", releaseDate=").append(releaseDate);
        sb.append(", serviceFit=").append(serviceFit);
        sb.append(", consumerFit=").append(consumerFit);
        sb.append(", interfaceVersion=").append(interfaceVersion);
        sb.append(", remark=").append(remark);
        sb.append("]");
        return sb.toString();
    }
}
