package com.my.pojo;

import lombok.*;
import org.apache.ibatis.type.Alias;

@Alias("hello")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//实体类
public class User {
    private int id;
    private String name;
    private String password;


}
