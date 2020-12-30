package com.my.service;


//真实对象(被代理的对象)
public class UserServiceImpl implements UserService {
    private UserServiceImpl userService;

    public UserServiceImpl(UserServiceImpl userService) {
        this.userService = userService;
    }
    public UserServiceImpl() {

    }

    public void add() {
        System.out.println("增加了一个用户！");
    }

    public void delete() {
        System.out.println("删除了一个用户！");
    }

    public void update() {
        System.out.println("修改了一个用户！");
    }

    public void select() {
        System.out.println("查询了一个用户！");
    }
}
