package 买苹果;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(count(n));
    }

    public static int count(int n){
        if(n%8==0){
            return n/8;
        }
        if(n < 6 || n%2!=0 || n==10){
            return -1;
        }

        return 1+n/8;

    }
}