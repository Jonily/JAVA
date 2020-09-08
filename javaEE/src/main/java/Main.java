import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
         String bit = (String) context.getBean("hhh");
       // String bit1 = (String) context.getBean("java.lang.String");
        System.out.println(bit);

        //通过类型获取bean对象，如果该类型有多个对象，就会报错，只支持一个
        String bit1 = (String) context.getBean(String.class);//只支持实例化一个
        System.out.println(bit1);

        Duck duck = (Duck)context.getBean("d1");
        System.out.println(duck);

        Duck2 duck2 = (Duck2)context.getBean("d2");
        System.out.println(duck2);
     /*   Duck3 duck3 = (Duck3)context.getBean("duck1");
        System.out.println(duck3);*/
/*

        DuckShop shop = (DuckShop) context.getBean("shop");
        System.out.println(shop);
*/

    }
}