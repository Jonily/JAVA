package com.my.pojo;

public class User {
    private String name;

    private String pwd;

    public User(String name, String pwd) {
        this.name = name;
        this.pwd = pwd;
    }
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    public String getPwd() {
        return pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void show(){
        System.out.println("name= "+name+ " pwd="+pwd);
    }
}
