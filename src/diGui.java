import java.util.Scanner;
public class diGui {
    public static void main(String[] args) {
        System.out.println("输入数字：");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("裴波那契数列第"+n+"项为：");
        int i = fun(n);
        System.out.println(i);
    }
    public static int fun(int n){
        int i = 0 ;
        if(n==1||n==2){
            return 1 ;
        }else if (n>=3){
            i = fun(n-1)+fun(n-2);
        }
        return i ;
    }
}

/*
    public static void main(String[] args) {
        System.out.println("输入数字：");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("每一位数字相加之和为：");
        int i = fun(n);
        System.out.println(i);
    }
    public static int fun(int n){
        int i = 0 ;
        if(n<9){
            return n ;
        }else{
            i = n%10 + fun(n/10);
        }
        return i ;
    }
    */
    /*public static void main(String[] args) {
        System.out.println("输入数字：");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("每一位数字为：");
        fun(n);
    }
    public static void fun(int n){
        if(n>9){
            fun(n/10);
        }
        System.out.print(" "+n%10+" ");
    }
    */

    /*public static void main(String[] args) {
        System.out.println("输入数字：");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long sum = fun(n);
        System.out.println("从1到"+n+"累加和为：");
        System.out.println(sum);
    }
    public static long fun(int n){
        long sum = 0 ;
        if(n==1){
            return 1 ;
        }else{
            sum = n + fun(n-1);
        }
        return sum ;
    }*/

/*

    public static void main1(String[] args) {
        System.out.println("输入数字：");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long sum = fun(n);
        System.out.println("第"+n+"项的阶乘为："+sum);
    }
    public static long fun(int n){
        long sum = 0L;
        if(n==1){
            return 1 ;
        }else{
            sum = n*fun(n-1);
        }
        return  sum;
    }
*/
