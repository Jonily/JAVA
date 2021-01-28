package com.my.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.text.SimpleDateFormat;
import java.util.Date;

public class JsonUtil {
    public static String getJson(Object o,String sdf){
        ObjectMapper mapper =new ObjectMapper();
        //不使用时间戳的方式
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        //自定义日期
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(sdf);
        //创建一个时间对象

        mapper.setDateFormat(simpleDateFormat);
        try {
            return mapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;

    }
}
