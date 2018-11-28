package com.dcmd.arch.api.entity;

import java.io.Serializable;

/**
 * @author 
 */
public class Plan implements Serializable {
    private Integer id;

    private String softprod;

    private String browser;

    private String version;

    private String remark;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSoftprod() {
        return softprod;
    }

    public void setSoftprod(String softprod) {
        this.softprod = softprod;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", softprod=").append(softprod);
        sb.append(", browser=").append(browser);
        sb.append(", version=").append(version);
        sb.append(", remark=").append(remark);
        sb.append("]");
        return sb.toString();
    }
}