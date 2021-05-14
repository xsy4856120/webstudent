package com.xsy.po;


public class Student {
    private Integer stuid;
    private String username;
    private String password;

    public Student(){

    }
    public Student(Integer stuid, String username, String password) {
        this.stuid = stuid;
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {
        return stuid;
    }

    public void setId(Integer id) {
        this.stuid = id;
    }
}
