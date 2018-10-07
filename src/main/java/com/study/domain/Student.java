package com.study.domain;

public class Student {
    private Integer studentid;

    private String studentname;

    private Integer schoolids;

    private School school;

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public Student(Integer studentid, String studentname, Integer schoolids) {
        this.studentid = studentid;
        this.studentname = studentname;
        this.schoolids = schoolids;
    }

    public Student() {
        super();
    }

    public Integer getStudentid() {
        return studentid;
    }

    public void setStudentid(Integer studentid) {
        this.studentid = studentid;
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname == null ? null : studentname.trim();
    }

    public Integer getSchoolids() {
        return schoolids;
    }

    public void setSchoolids(Integer schoolids) {
        this.schoolids = schoolids;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentid=" + studentid +
                ", studentname='" + studentname + '\'' +
                ", schoolids=" + schoolids +
                ", school=" + school +
                '}';
    }
}