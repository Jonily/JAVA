package 左右最值最大差;

import java.util.Arrays;

public class MaxGap {
    public static void main(String[] args) {
        int[]a = {28,75,38,44,66,1};
        System.out.println(findMaxGap(a,6));
    }
    public static int findMaxGap(int[] A, int n) {
        int k =n-2;
        int MAX = 0;
        for (int i = 0; i <= k ; i++) {
            int[] num1 = new int[i+1];
            int[] num2 = new int[n-(i+1)];
            for (int j = 0; j < num1.length ; j++) {
                num1[j] = A[j];
            }
            Arrays.sort(num1);
            int maxLeft = num1[num1.length-1];
            int p =i+1;
            for (int m = 0; m < num2.length ; m++) {
                num2[m] = A[p];
                p++;
            }
            Arrays.sort(num2);
            int maxRight = num2[num2.length-1];
            if(MAX < Math.abs(maxLeft-maxRight)){
                MAX = Math.abs(maxLeft-maxRight);
            }
        }
        return MAX;
    }
}