package DAO;

import model.User;

//实现三个功能
//1、插入用户 注册的时候使用
//2、按姓名查找 登陆时使用
//3、按照用户id查找 展示信息的时候使用
public class UserDao {
    public void add(User user){
        //1、先获取数据库连接DataSource
        //2、拼装sql语句 PrepareStatement
        //3、执行sql语句executeQuery、executrUpdate
        //4、关闭连
    }
}
