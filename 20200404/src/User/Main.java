package User;

import Book.BookList;

import java.util.Scanner;

/**
 * @Description:
 * @Author HuangZhuoLin
 * @Date 2020/4/4 10:53
 */

public class Main {
    //都继承User 返回值为User
    public static User login(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入姓名：");
        String name = scanner.nextLine();
        System.out.println("请输入身份：1-》管理员  0-》普通用户" );
        int num  = scanner.nextInt();
        if (num == 1){
            return new AdminUser(name);
        }else {
            return new NomalUser(name);

        }



    }

    public static void main(String[] args) {
        //准备书籍
        BookList bookList = new BookList();
        //登录
        User user = login();
        int choice = user.menu();
        //根据选择 确定调用的方法



    }
}
