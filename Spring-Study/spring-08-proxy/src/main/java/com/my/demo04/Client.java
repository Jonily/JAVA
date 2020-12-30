package com.my.demo04;

import com.my.demo02.UserService;
import com.my.demo02.UserServiceImpl;

public class Client {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        CreateProxy createProxy = new CreateProxy();
        createProxy.setTarget(userService);
        UserService userService1 = (UserService) createProxy.GetProxy();
        userService1.add();

    }
}
