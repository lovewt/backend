package com.dcmd.arch.api.entity;

import java.io.Serializable;

/**
 * @author 
 */
public class Question implements Serializable {
    private Integer id;

    private String softprod;

    private String browser;

    private String version;

    private String issue;

    private String solution;

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

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
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
        sb.append(", issue=").append(issue);
        sb.append(", solution=").append(solution);
        sb.append("]");
        return sb.toString();
    }

}