package 计算逆序对;

import java.util.Scanner;

public class Count {
    public static int count(int[] A, int n) {
        int count = 0;
        for (int i = 0; i < n ; i++) {

            for (int j = i+1; j < n; j++) {
                if(A[i] > A[j]){
                    count++;
                }
            }

        }
        return count;
    }
    public static void main(String[] args) {
        int[] A = {1,2,3,4,5,6,7,0};
        int b = count(A,8);
        System.out.println(b);

    }

}
