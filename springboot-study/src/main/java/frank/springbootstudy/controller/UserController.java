package frank.springbootstudy.controller;

import frank.springbootstudy.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller//当前类型注册实例到容器中，并指定为web请求的处理
@RequestMapping("/user")//可以定义请求相关的配置，如路径，请求方法等等
public class UserController {

    //装配Bean
    @Autowired
    private Map<Integer,String> test1;

    @Autowired
    private User user;

    @RequestMapping(value = "/login",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Object logon(){
    /*     Map<String ,String> map = new HashMap<>();
         map.put("man","jjj");
         map.put("rea","hkhk");
         return map;*/
        return user;
    }
}
