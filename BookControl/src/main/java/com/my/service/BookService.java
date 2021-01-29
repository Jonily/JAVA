package com.my.service;

import com.my.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookService {
    //增加一本书
    int addBook(Books books);
    //删除一本书
    int deleteBookById(int id);
    //修改一本书
    int updateBook(Books books);
    //查询一本书
    Books queryBookById( int id);
    //查询所有书
    List<Books> queryAllBook();
    //根据名字查找
    List<Books> queryBookByName(String bookName);
}
