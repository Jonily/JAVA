package 找出n个数里最小的k个;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String n = in.nextLine();
        String []a = null;
        a = n.split(" ");
        int k = 0;
        int []num = new int[a.length];
        for (int i = 0; i < a.length ; i++) {
            num[i] = Integer.parseInt(a[i]);
            k = num[a.length-1];
        }
        Arrays.sort(num,0,num.length-1);
        for (int i = 0; i < k; i++) {
            System.out.print(num[i] +" ");

        }

    }
}
