package com.my.service;

import com.my.dao.UserDao;


public class UserServiceImpl implements UserService {

    private UserDao userDao;
    //利用set进行注入
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void getUser() {
        userDao.getUser();

    }
    private UserDao userDao2;

    public void setUserDao2(UserDao userDao2) {
        this.userDao2 = userDao2;
    }
    public void getUser2() {
        userDao2.getUser();

    }

}
