import java.util.Scanner;
import java.util.concurrent.RejectedExecutionException;

/**
 * @Description:
 * @Author HuangZhuoLin
 * @Date 2020/4/15 8:59
 */

public class Test {
    public static void main(String[] args) {
           System.out.println("请输入密码：");
           Scanner sc = new Scanner(System.in);
           String a = sc.next();
           myEquals(a);
    }
    public static void myEquals(String a){
        if(a.equals("7758521")){
            System.out.println("输入成功！");
        }else {
            throw new RuntimeException("输入错误！");
        }
    }
}
