import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.zip.GZIPOutputStream;

public class Main {
    public static void main(String[] args) {
        /**
         * Spring 开启容器的方式: ApplicationContext 应用上下文(可以配置#营理Bean对象。及其他的工作)
         * ClassPathXmLApplicationContext 根据classpath路径，指定一个xml 文件(配置文件)。
         *并根据配置文件完成配置工作(Bean的实例化)
         */
        ApplicationContext context = new
                ClassPathXmlApplicationContext("applications.xml");

        //通过bean的名称获取bean对象，bean名称就是xml中bean的id
        Animals a1 = (Animals) context.getBean("a1");
        System.out.println(a1);


       Zoo zoo = (Zoo)context.getBean("zoo");
        System.out.println(zoo);

    }
}
