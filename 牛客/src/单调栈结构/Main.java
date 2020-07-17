package 单调栈结构;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            int[]num = new int[n];
            for (int i = 0; i <n; i++) {
                num[i] = in.nextInt();
            }
            Print(num,n);
        }
    }

    private static void Print(int[] num, int n) {
        int[]a = new int[2];
        for (int i = 0; i < n; i++) {
            int j = i;
            while (j>=0 && j< n){
                j-=1;
                if(j>=0){
                    if(num[j]<num[i]){
                        a[0] = j;
                        break;
                    }
                }else {
                    a[0] = -1;
                }
            }
             j = i;
            while (j>=0 && j< n){
                j+=1;
                if(j<n){
                    if(num[j]<num[i]){
                        a[1] = j;
                        break;
                    }
                }else {
                    a[1] = -1;
                }
            }
            System.out.println(a[0]+" "+a[1]);

        }
    }
}
