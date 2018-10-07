package com.study.domain;

import java.util.List;

public class School {
    private Integer schoolid;

    private String schoolname;

    private Integer studentids;

    private List<Student> studentList;
    public School(Integer schoolid, String schoolname, Integer studentids) {
        this.schoolid = schoolid;
        this.schoolname = schoolname;
        this.studentids = studentids;
    }

    public School() {
        super();
    }

    public Integer getSchoolid() {
        return schoolid;
    }

    public void setSchoolid(Integer schoolid) {
        this.schoolid = schoolid;
    }

    public String getSchoolname() {
        return schoolname;
    }

    public void setSchoolname(String schoolname) {
        this.schoolname = schoolname == null ? null : schoolname.trim();
    }

    public Integer getStudentids() {
        return studentids;
    }

    public void setStudentids(Integer studentids) {
        this.studentids = studentids;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    @Override
    public String toString() {
        return "School{" +
                "schoolid=" + schoolid +
                ", schoolname='" + schoolname + '\'' +
                ", studentids=" + studentids +
                ", studentList=" + studentList +
                '}';
    }
}