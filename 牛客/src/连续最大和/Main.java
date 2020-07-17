package 连续最大和;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            int[]num = new int[n];
            for (int i = 0; i < n ; i++) {
                num[i] = in.nextInt();
            }
                int sum = 0;
                int cursum = 0;
                int max = num[0];
                for (int i = 0; i < n; ++i) {
                    cursum += num[i];
                    if (cursum > sum)
                        sum = cursum;
                    if (cursum < 0)
                        cursum = 0;
                    if (num[i] > max)
                        max = num[i];
                }
                if (max < 0){
                    sum = max;
                }
            System.out.println(sum);
            }
    }
}