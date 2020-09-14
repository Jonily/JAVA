package frank.springbootstudy.config;


import frank.springbootstudy.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class AppConfig {

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
