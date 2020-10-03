package frank.config;


import com.fasterxml.jackson.databind.ObjectMapper;
import frank.config.interceptor.Logininterceptor;
import frank.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class AppConfig implements WebMvcConfigurer {//继承接口，web框架执行初始化的时候调用接口


    @Autowired
    private ObjectMapper objectMapper;
    @Override
    // /**静态资源也会被拦截，模糊匹配拦截

    //添加web配置，添加拦截器（根据路径拦截）
    /*:代表一级的路径，如/user/*，可以匹配到/user/abc，不能匹配/user/abc/1
    /* /**：代表多级路径

     */

    public void addInterceptors(InterceptorRegistry registry) {
        //实现用户会话管理功能
        registry.addInterceptor(new Logininterceptor(objectMapper))//链式方法设计，当前类型的方法，返回值就是this
       .addPathPatterns("/user/**")//添加要拦截的路径
        .excludePathPatterns("/user/login");//排除资源路径
    }

    @Bean
    public Map<Integer,String> test1() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "测试1下");
        map.put(2, "测试2下");
        return map;
    }
    @Bean
    public Map<Integer,String> test2() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "测试3下");
        map.put(2, "测试4下");
        return map;
    }

    @Bean
    public User user() {
        User user = new User();
        user.setUsername("hhh");
        user.setPassword("123456");
        return user;
    }

    @Bean
    public User user1() {
        User user = new User();
        user.setUsername("jjj");
        user.setPassword("456789");
        return user;
    }
}
