import java.util.Scanner;
public class biClass {
    public static void main(String[] args) {
        System.out.println("请输入数字：");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        fun(num);
    }
    public static void fun(int num){
        int i = 0 ;
        while(num!=0){
            i = num%10;
            num=num/10;
            System.out.print(" "+i+" ");

        }
    }
}
