package com.my.mapper;

import com.my.pojo.User;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

public class UserMapperImpl implements UserMapper {

    //原来所有的操作使用sqlSession执行，现在都使用SqlSessionTemplate
    private SqlSessionTemplate sqlSession ;

    public  void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    public List<User> selectUser() {
       UserMapper mapper =  sqlSession.getMapper(UserMapper.class);
       return mapper.selectUser();
    }


}
