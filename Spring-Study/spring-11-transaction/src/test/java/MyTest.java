import com.my.mapper.UserMapper;
import com.my.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.List;


public class MyTest {
    @Test
    public void Test() throws IOException {
        ApplicationContext context =  new ClassPathXmlApplicationContext("applicationConfig.xml");
       UserMapper userMapper =  context.getBean("userMapper",UserMapper.class);

       List<User> userList = userMapper.selectUser();//在执行查询的时候，需要先插入一个user，然后再删除

        for (User user : userList) {
            System.out.println(user);
        }

    }
}
