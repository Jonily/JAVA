package 最高分是多少;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int N = in.nextInt();
            int M = in.nextInt();
            int[]sore = new int[N];
            for (int i = 0; i <sore.length ; i++) {
                sore[i] = in.nextInt();
            }

            String c = "";
            int A= 0;
            int B = 0;

            for(int i=0;  i< M; i++){
                c  = in.next();
                A = in.nextInt();
                B = in.nextInt();
                process(c,A,B,sore);
            }
        }
    }
    public static void process(String c, int A, int B, int[] sore){
        int begin =0;
        int end = 0;

        if(c.equals("Q")){
            end = Math.max(A, B);
            begin = Math.min(A, B)-1;
            int max = sore[begin];
            for(int i = begin;i < end;i++){
                if(max < sore[i]){
                    max = sore[i];
                }
            }
            System.out.println(max);
        }else if(c.equals("U")){
            sore[A-1] = B;
        }
    }
}
