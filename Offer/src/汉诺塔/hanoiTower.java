package 汉诺塔;

import java.util.Scanner;

public class hanoiTower {
   /* public static void main(String[] args) {
        System.out.println("输入要移动的盘子数：");
        Scanner in= new Scanner(System.in);
        int n = in.nextInt();
        char A = 'A';
        char B = 'B';
        char C = 'C';
        System.out.println("需要步骤：");
        hanoi(n,A,B,C);

    }

    public static void mov(char A,char C){
        System.out.println(A+"->"+C);
    }

    public static void hanoi(int n, char A, char  B, char C) {
        if (n == 1){
            mov(A,C);
        }else {
            hanoi(n-1,A,C,B);
            mov(A,C);
            hanoi(n-1,B,A,C);

        }
    }*/
   public static void  main(String[] args) {
       System.out.println("输入盘子数目：");
       Scanner in = new Scanner(System.in);
       int n = in.nextInt();
       char A = 'A';
       char B = 'B';
       char C = 'C';
       hanno(n, A, B, C);

   }

       public static void mov(char A, char C){
           System.out.println(A+"->"+C);

       }

       public static void hanno(int n,char A,char B,char C){
           if(n == 1){
               mov(A,C);
           }else{
               hanno(n-1,A,C,B);
               mov(A,C);
               hanno(n-1,B,A,C);

           }

       }



}
