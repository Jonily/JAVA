package 数字之和;

import java.util.Scanner;

public class Add {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()){
            int n = in.nextInt();
            if(n<10){
                int a = (int) Math.pow(n,2);
                int b = a%10;
                int c= a/10;
                System.out.println(n+" "+(b+c));
            }else {
                int num = n;
                int count = 0;
                int count1 = 0;
                while (n >0){
                    int d = n%10;
                    count+=d;
                    n/=10;
                }
                int e = (int)Math.pow(num,2);
                while (e >0){
                    int f = e%10;
                    count1+=f;
                    e/=10;
                }
                System.out.println(count+" "+count1);
            }
        }
    }
}
