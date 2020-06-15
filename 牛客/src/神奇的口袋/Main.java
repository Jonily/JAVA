package 神奇的口袋;

import java.util.*;
public class Main {
    static int[] weight;
    static int N;
    static int count=0;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            N = input.nextInt();
            weight = new int[N+1];
            for (int i = 1; i <= N; i++) {
                weight[i] = input.nextInt();
            }
            count(40,N);
            System.out.println(count);
        }
    }
    public static void count(int s,int n) {
    //如果正好装满
     if(s==0) {
        ++count;
        return ;
    }
      //是s<0或n<1则不能完成
        if(s<0||(s>0&&n<1))
            return ;
    count(s-weight[n],n-1);
    count(s,n-1);
}
}