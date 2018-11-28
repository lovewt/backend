package com.dcmd.arch.api.entity;

public class InterfaceIO {
    private String id;

    /**
     * 接口编号
     */
    private String intServiceNum;

    /**
     * 输入/输出
     */
    private String type;

    /**
     * 输入/输出名称
     */
    private String typeName;


    /**
     * 输入输出字段英文名称
     */
    private String nameEn;

    /**
     * 输入输出字段中文名称
     */
    private String nameCn;

    /**
     * 输入输出字段类型
     */
    private String fieldType;

    /**
     * 输入字段是否必输
     */
    private String lob;

    /**
     * 字段示列
     */
    private String example;

    /**
     * 描述
     */
    private String describes;

    private String orders;

    /**
     * 1:待复核，0：通过，-1：不通过
     */
    private String status;

    private String typeVal;

    private static final long serialVersionUID = 1L;



    public String getIntServiceNum() {
        return intServiceNum;
    }

    public void setIntServiceNum(String intServiceNum) {
        this.intServiceNum = intServiceNum;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public String getNameCn() {
        return nameCn;
    }

    public void setNameCn(String nameCn) {
        this.nameCn = nameCn;
    }

    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    public String getLob() {
        return lob;
    }

    public void setLob(String lob) {
        this.lob = lob;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public String getDescribes() {
        return describes;
    }

    public void setDescribes(String describes) {
        this.describes = describes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getOrders() {
        return orders;
    }

    public void setOrders(String orders) {
        this.orders = orders;
    }

    public String getTypeVal() {
        return typeVal;
    }

    public void setTypeVal(String typeVal) {
        this.typeVal = typeVal;
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
        sb.append(", intServiceNum=").append(intServiceNum);
        sb.append(", type=").append(type);
        sb.append(", nameEn=").append(nameEn);
        sb.append(", nameCn=").append(nameCn);
        sb.append(", fieldType=").append(fieldType);
        sb.append(", lob=").append(lob);
        sb.append(", example=").append(example);
        sb.append(", describe=").append(describes);
        sb.append(", orders=").append(orders);
        sb.append(", status=").append(status);
        sb.append(", typeVal=").append(typeVal);
        sb.append("]");
        return sb.toString();
    }

}
