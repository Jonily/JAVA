package com.my.service;

import com.my.dao.UserMapper;
import com.my.pojo.User;

public class UserServiceImpl implements UserService {


    private UserMapper userMapper;
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }


    public User findUser(String userName, String passWord) {
        return userMapper.findUser(userName,passWord);
    }

    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    public boolean findUserByName(String userName) {
        if(userMapper.findUserByName(userName) != null){
            return false;
        }else {
            return true;
        }
    }

    public int deleteUserById(int id) {
        return userMapper.deleteUserById(id);
    }
}
