package User;
import java.util.Scanner;
/**
 * @Description:
 * @Author HuangZhuoLin
 * @Date 2020/4/4 10:44
 */

public class AdminUser extends User {

    public AdminUser(String name){
        super(name);

    }

    public int menu(){
        System.out.println("Hello "+this.name+" 欢迎来到图书馆!");
        System.out.println("====(1) 查找图书===");
        System.out.println("====(2) 新增书籍===");
        System.out.println("====(3) 删除书籍===");
        System.out.println("====(4) 打印书籍===");
        System.out.println("====(0) 退出系统===");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        return choice;
    }
}
