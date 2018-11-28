package com.dcmd.arch.api.entity;

import java.io.Serializable;

/**
 * @author 
 */
public class Standard implements Serializable {
    private Integer id;

    private String usertype;

    private String browser;

    private String version;

    private String standard;

    private String remarks;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", usertype=").append(usertype);
        sb.append(", browser=").append(browser);
        sb.append(", version=").append(version);
        sb.append(", standard=").append(standard);
        sb.append(", remarks=").append(remarks);
        sb.append("]");
        return sb.toString();
    }
}