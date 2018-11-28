package com.dcmd.arch.api.entity;

import java.io.Serializable;

/**
 * @author 
 */
public class TInstitution implements Serializable {
    private String instno;

    private String instname;

    private String instproperty;

    private String highinstno;

    private String highinstname;

    private static final long serialVersionUID = 1L;

    public String getInstno() {
        return instno;
    }

    public void setInstno(String instno) {
        this.instno = instno;
    }

    public String getInstname() {
        return instname;
    }

    public void setInstname(String instname) {
        this.instname = instname;
    }

    public String getInstproperty() {
        return instproperty;
    }

    public void setInstproperty(String instproperty) {
        this.instproperty = instproperty;
    }

    public String getHighinstno() {
        return highinstno;
    }

    public void setHighinstno(String highinstno) {
        this.highinstno = highinstno;
    }

    public String getHighinstname() {
        return highinstname;
    }

    public void setHighinstname(String highinstname) {
        this.highinstname = highinstname;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", instno=").append(instno);
        sb.append(", instname=").append(instname);
        sb.append(", instproperty=").append(instproperty);
        sb.append(", highinstno=").append(highinstno);
        sb.append(", highinstname=").append(highinstname);
        sb.append("]");
        return sb.toString();
    }

}