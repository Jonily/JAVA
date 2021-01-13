package com.my.mapper;

import com.my.pojo.User;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

public class UserMapperImpl extends SqlSessionDaoSupport implements UserMapper {


    public List<User> selectUser() {

        User user = new User(1,"奥特曼","1231654643164");
       UserMapper mapper =  getSqlSession().getMapper(UserMapper.class);

       mapper.addUser(user);
       mapper.deleteUserById(1);
       return mapper.selectUser();
    }

    public int addUser(User user) {
        return getSqlSession().getMapper(UserMapper.class).addUser(user);
    }

    public int deleteUserById(int id) {
        return getSqlSession().getMapper(UserMapper.class).deleteUserById(id);
    }


}
