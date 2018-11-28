package com.dcmd.service.business.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * 业务功能
 *
 * @author
 */
@TableName("t_comp_business_level")
public class BusinessLevel implements Serializable {
    /**
     * 主键Id
     */
    private String id;

    /**
     * 名称
     */
    private String name;

    /**
     * 上级ID
     */
    private String pid;

    /**
     * 功能点与业务关联；1-直接，2-间接
     */
    @TableField(value = "features_business")
    private String featuresBusiness;

    private String featuresBusinessName;

    /**
     * 关联核心业务系统I名称
     */
    @TableField(value = "software_num")
    private String softwareNum;

    private String softwareName;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
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

    public String getFeaturesBusinessName() {
        return featuresBusinessName;
    }

    public void setFeaturesBusinessName(String featuresBusinessName) {
        this.featuresBusinessName = featuresBusinessName;
    }

    public String getSoftwareName() {
        return softwareName;
    }

    public void setSoftwareName(String softwareName) {
        this.softwareName = softwareName;
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

    @Override
    public String toString() {
        return "BusinessLevel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pid=" + pid +
                ", featuresBusiness='" + featuresBusiness + '\'' +
                ", softwareNum='" + softwareNum + '\'' +
                '}';
    }
}