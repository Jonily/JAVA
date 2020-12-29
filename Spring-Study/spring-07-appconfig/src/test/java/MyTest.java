import com.my.config.MyConfig;
import com.my.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyTest {
    @Test
    public void Test(){
        //如果完全使用配置类方式去做，就只能通过AnnotationConfig 上下文来获取容器，通过配置类的class对象加载
        ApplicationContext context =  new AnnotationConfigApplicationContext(MyConfig.class);
        User user = (User) context.getBean("getUser");
        System.out.println(user.getName());

    }
}
