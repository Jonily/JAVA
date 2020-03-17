/**
 * @Description: 随机点名器
 * @Author HuangZhuoLin
 * @Date 2020/3/18 1:00
 */
import java.util.Random;
import java.util.Scanner;
public class callName {
    public static void main(String[] args) {
        System.out.println("------------随机点名器------------");
        String[] student =  new String[10];
        Scanner sc = new Scanner(System.in);
        System.out.println("您的学生数量为：");
        int i = sc.nextInt();
        boolean flag = true;
        System.out.println();
        while(flag){
            System.out.println("请选择序号来进行下一步操作：");
            System.out.println("================================");
            System.out.println("      （1）添加学生");
            System.out.println("      （2）浏览学生");
            System.out.println("      （3）随机点名");
            System.out.println("      （4）退   出");
            int n = sc.nextInt();
        switch (n){
            case 1:{
                addstudent(student,i);
                System.out.println();
                break;
            }
            case 2:{
                printstudent(student,i);
                System.out.println();
                break;
            }
            case 3:{
             String name = randomstudent(student,i);
                System.out.println("   被点到名字的同学是："+name);
                break;
            }
            case 4:{
                flag = false;
                break;
            }
            default:{
                System.out.println("      输入错误，请重新输入！");
                System.out.println();
                break;
            }
          }
        }
    }
    public static void addstudent(String[] stu,int i){
        Scanner sc = new Scanner(System.in);
        int a = 0;
        for (a = 0; a<i; a++ ){
            System.out.println("  储存第"+(a+1)+"个姓名：");
               stu[a] = sc.next();
        }
    }
    public static void printstudent(String[] stu,int i){
        System.out.println("您的学生有：");
        for (int a = 0; a<i; a++ ){
            System.out.print(" "+ stu[a] +" ");
        }
        System.out.println();
    }
    public static String randomstudent(String[] stu,int i){
        int a = new Random().nextInt(i);
        System.out.println("      第"+(a+1)+"个同学被点到了！");
        String name = stu[a];
        return name ;
    }
}
