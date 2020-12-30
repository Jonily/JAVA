package com.my.demo02;

public class UserServiceProxy implements UserService {
    private UserServiceImpl userService;

    public UserServiceProxy() {
    }

    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }

    public void add() {
        log("add");
        userService.add();
    }

    public void delete() {
        userService.delete();
    }

    public void update() {
        userService.update();
    }

    public void select() {
        userService.select();
    }

    //增添一个打印日志
    public void log(String s){
        System.out.println("[Debug]使用了"+s+"方法");

    }

}
