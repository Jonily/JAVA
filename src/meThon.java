import java.util.Scanner;
public class meThon {

    public static void main (String[]args){
        System.out.println("请输入数字：");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        fun(n);
    }
    public static void fun (int n){
        int i = 0 ;
        System.out.println("奇数位：");
        for (i = 31 ; i>=1 ; i-=2 ){
            System.out.print( ((n>>>i) & 1) + " ");
        }
        System.out.println(" ");
        System.out.println("偶数位：");
        for (i = 30 ; i>=0 ; i-=2 ){
            System.out.print( ((n>>>i) & 1) +" ");
        }
    }
}

