
import com.my.service.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {
      //直接获取bean对象
        //获取Spring的上下文对象
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        //我们的对象都在Spring中管理要使用的话就从Spring容器中取出来
        UserServiceImpl userService = (UserServiceImpl) context.getBean("UserServiceImpl");

        userService.getUser();
        userService.getUser2();

    }
}
