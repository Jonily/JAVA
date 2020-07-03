package 大整数排序;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            BigInteger[] bigNum = new BigInteger[n];
            for (int i = 0; i < n ; i++) {
                bigNum[i] = in.nextBigInteger();
            }
            Arrays.sort(bigNum);
            for (int i = 0; i < bigNum.length ; i++) {
                System.out.println(bigNum[i]);
            }
        }
    }
}
