package com.dcmd.arch.api.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class TUsermaster implements Serializable {
    private String employeeid;

    private String gender;

    private String name;

    private String tel;

    private String mobile;

    private String email;

    private String departmentno;

    private String department;

    private String reldepartmentno;

    private String reldepartment;

    private String company;

    private String isemployee;

    private String prquestion;

    private String pranswer;

    private String otmid;

    private String title;

    private String role;

    private String status;

    private String comment;

    private Date lastupdatets;

    private String badgenumber;

    private Date createts;

    private static final long serialVersionUID = 1L;

    public String getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(String employeeid) {
        this.employeeid = employeeid;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartmentno() {
        return departmentno;
    }

    public void setDepartmentno(String departmentno) {
        this.departmentno = departmentno;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getReldepartmentno() {
        return reldepartmentno;
    }

    public void setReldepartmentno(String reldepartmentno) {
        this.reldepartmentno = reldepartmentno;
    }

    public String getReldepartment() {
        return reldepartment;
    }

    public void setReldepartment(String reldepartment) {
        this.reldepartment = reldepartment;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getIsemployee() {
        return isemployee;
    }

    public void setIsemployee(String isemployee) {
        this.isemployee = isemployee;
    }

    public String getPrquestion() {
        return prquestion;
    }

    public void setPrquestion(String prquestion) {
        this.prquestion = prquestion;
    }

    public String getPranswer() {
        return pranswer;
    }

    public void setPranswer(String pranswer) {
        this.pranswer = pranswer;
    }

    public String getOtmid() {
        return otmid;
    }

    public void setOtmid(String otmid) {
        this.otmid = otmid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getLastupdatets() {
        return lastupdatets;
    }

    public void setLastupdatets(Date lastupdatets) {
        this.lastupdatets = lastupdatets;
    }

    public String getBadgenumber() {
        return badgenumber;
    }

    public void setBadgenumber(String badgenumber) {
        this.badgenumber = badgenumber;
    }

    public Date getCreatets() {
        return createts;
    }

    public void setCreatets(Date createts) {
        this.createts = createts;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", employeeid=").append(employeeid);
        sb.append(", gender=").append(gender);
        sb.append(", name=").append(name);
        sb.append(", tel=").append(tel);
        sb.append(", mobile=").append(mobile);
        sb.append(", email=").append(email);
        sb.append(", departmentno=").append(departmentno);
        sb.append(", department=").append(department);
        sb.append(", reldepartmentno=").append(reldepartmentno);
        sb.append(", reldepartment=").append(reldepartment);
        sb.append(", company=").append(company);
        sb.append(", isemployee=").append(isemployee);
        sb.append(", prquestion=").append(prquestion);
        sb.append(", pranswer=").append(pranswer);
        sb.append(", otmid=").append(otmid);
        sb.append(", title=").append(title);
        sb.append(", role=").append(role);
        sb.append(", status=").append(status);
        sb.append(", comment=").append(comment);
        sb.append(", lastupdatets=").append(lastupdatets);
        sb.append(", badgenumber=").append(badgenumber);
        sb.append(", createts=").append(createts);
        sb.append("]");
        return sb.toString();
    }

}