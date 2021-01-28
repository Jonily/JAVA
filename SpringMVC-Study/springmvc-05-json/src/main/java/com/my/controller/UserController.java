package com.my.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.my.pojo.User;
import com.my.util.JsonUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class UserController {

    @RequestMapping("/json1")
    public String json1() throws JsonProcessingException {
        //创建一个jackson的对象映射器，用来解析数据
        ObjectMapper mapper = new ObjectMapper();
        //创建一个对象
        User user = new User("韦德1",3,"男");
        //将我们的对象解析成为json格式
        String str  = mapper.writeValueAsString(user);
        //由于@ResponseBody注解，这里会将str转成json格式返回；十分方便
        return str;
    }

    @RequestMapping("/json2")
    public String json2() throws JsonProcessingException {
        //创建一个jackson的对象映射器，用来解析数据
        ObjectMapper mapper = new ObjectMapper();
        //创建一个对象
        User user1 = new User("韦德1",3,"男");
        User user2 = new User("韦德2",3,"男");
        User user3 = new User("韦德3",3,"男");
        User user4 = new User("韦德4",3,"男");

        List<User> userList = new ArrayList<User>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        //将我们的对象解析成为json格式
        String str  = mapper.writeValueAsString(userList);
        //由于@ResponseBody注解，这里会将str转成json格式返回；十分方便
        return str;
    }

   @RequestMapping("/json3")
    public String json3() throws JsonProcessingException {
        //创建一个jackson的对象映射器，用来解析数据
         ObjectMapper mapper = new ObjectMapper();
        //使用ObjectMapper来格式化输出
        //不使用时间戳的方式
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        //自定义日期
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //创建一个时间对象
        Date date = new Date();
        mapper.setDateFormat(simpleDateFormat);
        //将我们的对象解析成为json格式
        //Jackson 默认是会把时间转成timestamps形式
        String str  = mapper.writeValueAsString(date);
        //由于@ResponseBody注解，这里会将str转成json格式返回；十分方便
        return str;
    }
    @RequestMapping("/json4")
    public String json4() throws JsonProcessingException {
        //创建一个时间对象
        Date date = new Date();

        return JsonUtil.getJson(date,"yyyy-MM-dd HH:mm:ss");
    }

    @RequestMapping("/json5")
    public void json5() throws JsonProcessingException {
        //创建一个对象
        User user1 = new User("秦疆1号", 3, "男");
        User user2 = new User("秦疆2号", 3, "男");
        User user3 = new User("秦疆3号", 3, "男");
        User user4 = new User("秦疆4号", 3, "男");
        List<User> list = new ArrayList<User>();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);

        System.out.println("*******Java对象 转 JSON字符串*******");
        String str1 = JSON.toJSONString(list);
        System.out.println("JSON.toJSONString(list)==>"+str1);
        String str2 = JSON.toJSONString(user1);
        System.out.println("JSON.toJSONString(user1)==>"+str2);

        System.out.println("\n****** JSON字符串 转 Java对象*******");
        User jp_user1=JSON.parseObject(str2,User.class);
        System.out.println("JSON.parseObject(str2,User.class)==>"+jp_user1);

        System.out.println("\n****** Java对象 转 JSON对象 ******");
        JSONObject jsonObject1 = (JSONObject) JSON.toJSON(user2);
        System.out.println("(JSONObject) JSON.toJSON(user2)==>"+jsonObject1.getString("name"));

        System.out.println("\n****** JSON对象 转 Java对象 ******");
        User to_java_user = JSON.toJavaObject(jsonObject1, User.class);
        System.out.println("JSON.toJavaObject(jsonObject1, User.class)==>"+to_java_user);

    }
}
