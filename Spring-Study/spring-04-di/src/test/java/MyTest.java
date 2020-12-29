import com.my.pojo.Student;
import com.my.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class MyTest {
    public static void main(String[] args) {
        ApplicationContext context =  new ClassPathXmlApplicationContext("beans.xml");
        Student student = (Student) context.getBean("student");

        System.out.println(student.getName());
        System.out.println(student.getAddress());
        System.out.println(Arrays.toString(student.getBooks()));
        System.out.println(student.getHobbies());
        System.out.println(student.getCard());
        System.out.println(student.getGames());
        System.out.println(student.getWife());
        System.out.println(student.getInfo());
        System.out.println();
        System.out.println("====================================");
        System.out.println(student);

    }

    @Test
    public void Test(){
        ApplicationContext context =  new ClassPathXmlApplicationContext("userBean.xml");
        User user =  context.getBean("user2",User.class);
        User user2 =  context.getBean("user2",User.class);

        System.out.println(user == user2);
    }
}
