package User;

/**
 * @Description:
 * @Author HuangZhuoLin
 * @Date 2020/4/4 10:44
 */

public class AdminUser extends User {

    public int menu(){
        System.out.println("====1、查找图书===");
        System.out.println("====2、新增书籍===");
        System.out.println("====3、删除书籍===");
        System.out.println("====4、打印书籍===");
        System.out.println("====0、退出系统===");
        int choice = scanner.nextInt;
        return choice;
    }
}
