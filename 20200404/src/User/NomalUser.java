package User;


import java.util.Scanner;

/**
 * @Description:
 * @Author HuangZhuoLin
 * @Date 2020/4/4 10:44
 */

public class NomalUser extends User {

    public int menu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("====1、查找图书===");
        System.out.println("====2、借阅书籍===");
        System.out.println("====3、归还书籍===");
        System.out.println("====0、退出系统===");
    }

}
