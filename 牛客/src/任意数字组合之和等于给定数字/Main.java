package 任意数字组合之和等于给定数字;

import java.util.Scanner;
public class Main {
    static  int[] record ;
    static  int n ;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        record =new int[n];
        for (int i = 0; i < n; i++) {
            record[i]=scanner.nextInt();
        }
        int count = fun(0, 40);
        System.out.println(count);
    }
    public static int  fun(int i,int sum){
        //结束
        if (i==n) {
            return 0;
        }
        if (record[i]==sum) {
            return 1+fun(i+1,sum);
        } else if (sum>record[i]){
            return fun(i+1,sum-record[i])+fun(i+1,sum);
        }
        //sum<record[i]
        return fun(i+1,sum);
    }
}