package com.xsy.po;

public class Class {
    private Integer cid;
    private Teacher teacher;
    private String cName;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getcName() {
        return cName;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

}
