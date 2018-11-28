package com.dcmd.service.business.entity;

public class SoftwareProduct {
    /**
     * 软件产品编号 softwareNum
     */
    private String softwareNum;

    /**
     * 软件产品名称
     */
    private String softwareName;

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
}
