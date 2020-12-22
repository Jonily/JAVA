package com.my.dao;

import com.my.pojo.Blog;

import java.util.List;
import java.util.Map;


public interface BlogMapper {
    //插入数据
    int addBook(Blog blog);

    //查询博客
    List<Blog> queryBlogIf(Map map);


    List<Blog> queryBlogChoose(Map map);

    //修改博客
    int updateBlog(Map map);


    //查询1 2 4号博客
    List<Blog> queryBlogForeach(Map map);
}