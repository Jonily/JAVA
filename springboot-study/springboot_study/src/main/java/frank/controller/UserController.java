package main.java.frank.controller;

import frank.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller//当前类型注册实例到容器中，并指定为web请求的处理
@RequestMapping("/user")//可以定义请求相关的配置，如路径，请求方法等等
public class UserController {
    @Autowired
    private User user;//变量名和Bean的名称要一致否则会报错

    @RequestMapping("/m")
  public String m(){
      return "/main.html";
    }


 //装配Bean
    @Autowired
    private Map<Integer,String> test1;


/*
 @Autowired
    private User user;//变量名和Bean的名称要一致否则会报错

    //变量名和Bean的名称不一致使用@Autowired搭配@Qulifier指定Bean名称
    @Autowired
    @Qualifier("user1")
    private User user1246;*//*

  @Resource(name = "user1")
  private User user;

/*  @RequestMapping(value = "/login",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  @ResponseBody
  public Object logon(){
   Map<String ,String> map = new HashMap<>();
         map.put("man","jjj");
         map.put("rea","hkhk");
         return map;

    return user;

  }*/

    @RequestMapping(value = "/login",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Object login(User user,HttpServletRequest req ) {
        //模拟数据库中校验用户名密码
        if(!"abc".equals(user.getUsername())){
            throw new RuntimeException("用户登录失败");
        }
        HttpSession session = req.getSession();
        session.setAttribute("user",user);
        return user;
    }
    @RequestMapping("/m1")
    public String m1(){
        //返回路径不带/ ，以当前请求路径为相对位置，同一级查找资源路径
        // 但是如果返回路径带/就会去掉这个路径，以项目部署路径为相对位置
        //return "forward:login";//不带/，以当前请求路径/user/m1 转发到/user同一级查找资源路径
        return "forward:/user/login";//带/，以项目部署路径为相对位置，项目路径查找login

    }

    @RequestMapping("/m2")
    public String m2(){
        return "redirect:/user/login";
    }
    @RequestMapping("/test/{key}")//路径中使用变量占位符
    @ResponseBody
    public Object test1(@PathVariable("key") Integer k){
        System.out.println("==========="+test1.get(k));
        return test1;
    }


    //请求Get /user/test2？k1=v1 & k2=v2
    @RequestMapping(value = "/test2",method = {RequestMethod.POST,RequestMethod.GET })
    @ResponseBody
    public  Object test2(@RequestParam("k1") String k1,//写全的做法
                         @RequestParam String k2,//省略注释解值的做法，默认以变量key查找请求数据
                          String k3){//最省略的做法，默认就是 @RequestParam注解
        System.out.println("============"+k1+"==="+k2+"====="+k3);
        return test1;
    }
    @RequestMapping("/test3")
    @ResponseBody
    public Object test3(User user){//请求数据自动映射到参数类型的属性中：username=xxx&password=xxx
        System.out.println(user);
        return test1;

    }

    @RequestMapping("/test4")
    @ResponseBody
    public Object test4(){
        return null;
    }

    @RequestMapping("/test5")
    @ResponseBody
    public Object test5(){
        return "ok";
    }

    @RequestMapping("/test6")
    @ResponseBody
    //http请求是基于Servlet的，Spring已经生成了request和response对象，可以直接在参数中使用
    public Object test6(HttpServletRequest req, HttpServletResponse res){//spring自动将对象注入到参数
        System.out.println("==========="+req.getParameter("username")+"====="+req.getParameter("password"));
        return null;
    }

    @RequestMapping("/test7")
    @ResponseBody
    public Object test7 (@RequestBody User user){//请求数据类型为json时，解析时需要加注解
        System.out.println("====="+user);
        return null;
    }


    @RequestMapping("/test8")
    @ResponseBody
    public Object test8() {
        throw new RuntimeException("数据库报错");

    }

}
