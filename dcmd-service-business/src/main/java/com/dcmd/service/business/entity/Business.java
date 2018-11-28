package com.dcmd.service.business.entity;

import java.io.Serializable;

/**业务功能
 * @author
 */
public class Business implements Serializable {
    /**
     * 主键Id
     */
    private String id;

    private String name;

    private String pid;

    private String businessId;

    private String businessClassId;

    private String businessClass;

    /**
     * 一级
     */
    private String oneLevelId;
    private String oneLevel;

    /**
     * 二级
     */
    private String twoLevelId;
    private String twoLevel;

    /**
     * 三级
     */
    private String threeLevelId;
    private String threeLevel;

    /**
     * 四级
     */
    private String fourLevelId;
    private String fourLevel;

    /**
     * 五级
     */
    private String fiveLevelId;
    private String fiveLevel;

    /**
     * 功能点
     */
    private String featuresId;
    private String features;

    /**
     * 功能点与业务关联；1-直接，2-间接
     */
    private String featuresBusiness;

    private String featuresBusinessName;

    /**
     * 关联核心业务系统ID
     */
    private String softwareNum;

    private String softwareName;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getBusinessClass() {
        return businessClass;
    }

    public void setBusinessClass(String businessClass) {
        this.businessClass = businessClass;
    }

    public String getOneLevel() {
        return oneLevel;
    }

    public void setOneLevel(String oneLevel) {
        this.oneLevel = oneLevel;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public String getTwoLevel() {
        return twoLevel;
    }

    public void setTwoLevel(String twoLevel) {
        this.twoLevel = twoLevel;
    }

    public String getFeaturesBusinessName() {
        return featuresBusinessName;
    }

    public void setFeaturesBusinessName(String featuresBusinessName) {
        this.featuresBusinessName = featuresBusinessName;
    }

    public String getThreeLevel() {
        return threeLevel;
    }

    public void setThreeLevel(String threeLevel) {
        this.threeLevel = threeLevel;
    }

    public String getFourLevel() {
        return fourLevel;
    }

    public void setFourLevel(String fourLevel) {
        this.fourLevel = fourLevel;
    }

    public String getFiveLevel() {
        return fiveLevel;
    }

    public void setFiveLevel(String fiveLevel) {
        this.fiveLevel = fiveLevel;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    public String getFeaturesBusiness() {
        return featuresBusiness;
    }

    public void setFeaturesBusiness(String featuresBusiness) {
        this.featuresBusiness = featuresBusiness;
    }

    public String getSoftwareNum() {
        return softwareNum;
    }

    public void setSoftwareNum(String softwareNum) {
        this.softwareNum = softwareNum;
    }

    public String getSoftwareName() {
        return softwareName;
    }

    public void setSoftwareName(String softwareName) {
        this.softwareName = softwareName;
    }

    public String getBusinessClassId() {
        return businessClassId;
    }

    public void setBusinessClassId(String businessClassId) {
        this.businessClassId = businessClassId;
    }

    public String getOneLevelId() {
        return oneLevelId;
    }

    public void setOneLevelId(String oneLevelId) {
        this.oneLevelId = oneLevelId;
    }

    public String getTwoLevelId() {
        return twoLevelId;
    }

    public void setTwoLevelId(String twoLevelId) {
        this.twoLevelId = twoLevelId;
    }

    public String getThreeLevelId() {
        return threeLevelId;
    }

    public void setThreeLevelId(String threeLevelId) {
        this.threeLevelId = threeLevelId;
    }

    public String getFourLevelId() {
        return fourLevelId;
    }

    public void setFourLevelId(String fourLevelId) {
        this.fourLevelId = fourLevelId;
    }

    public String getFiveLevelId() {
        return fiveLevelId;
    }

    public void setFiveLevelId(String fiveLevelId) {
        this.fiveLevelId = fiveLevelId;
    }

    public String getFeaturesId() {
        return featuresId;
    }

    public void setFeaturesId(String featuresId) {
        this.featuresId = featuresId;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", businessClass=").append(businessClass);
        sb.append(", oneLevel=").append(oneLevel);
        sb.append(", twoLevel=").append(twoLevel);
        sb.append(", threeLevel=").append(threeLevel);
        sb.append(", fourLevel=").append(fourLevel);
        sb.append(", fiveLevel=").append(fiveLevel);
        sb.append(", features=").append(features);
        sb.append(", featuresBusiness=").append(featuresBusiness);
        sb.append(", softwareNum=").append(softwareNum);
        sb.append("]");
        return sb.toString();
    }
}