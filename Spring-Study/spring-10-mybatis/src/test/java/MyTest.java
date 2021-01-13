import com.my.mapper.UserMapper;
import com.my.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;


public class MyTest {
    @Test
    public void Test() throws IOException {
        ApplicationContext context =  new ClassPathXmlApplicationContext("spring-mybatis.xml");
       UserMapper userMapper =  context.getBean("userMapper2",UserMapper.class);
        for (User user : userMapper.selectUser()) {
            System.out.println(user);
        }

    }
}
