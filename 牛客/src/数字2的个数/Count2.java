package 数字2的个数;

import java.util.*;



public class Count2 {
    public static void main(String[]args){
        Scanner in = new Scanner(System.in);
        System.out.println(countNumberOf2s(in.nextInt()));


    }
    public static int countNumberOf2s(int n) {
        int count = 0;
        for (int i = 1; i <= n; i *= 10) {
            int a = n / i;
            int b = n % i;
            //之所以补8，是因为当百位为0，则a/10==(a+8)/10，
            //当百位>=2，补8会产生进位位，效果等同于(a/10+1)
            count += (a + 7) / 10 * i + ((a % 10 == 2) ? b + 1 : 0);
        }
        return count;
    }
}