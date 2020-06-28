package 学分绩点;

import java.util.Scanner;

public class Sore {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            int[] pro = new int[n];
            int[]pSore = new int[n];
            double GPA = 0;
            double count = 0;
            for (int i = 0; i < n ; i++) {
                pro[i] = in.nextInt();
                count+=pro[i];
            }
            for (int i = 0; i < n ; i++) {
                pSore[i] = in.nextInt();
            }
            for (int k = 0; k < n; k++) {
                if(pSore[k]>= 90){
                    GPA+=pro[k]*4.0;
                }else if(pSore[k]>= 85){
                    GPA+=pro[k]*3.7;
                }else if(pSore[k]>= 82){
                    GPA+=pro[k]*3.3;
                }else if(pSore[k]>= 78){
                    GPA+=pro[k]*3.0;
                } else if(pSore[k]>= 75){
                    GPA+=pro[k]*2.7;
                }else if(pSore[k]>= 72){
                    GPA+=pro[k]*2.3;
                }else if(pSore[k]>= 68){
                    GPA+=pro[k]*2.0;
                }else if(pSore[k]>= 64){
                    GPA+=pro[k]*1.5;
                }else if(pSore[k]>= 60){
                    GPA+=pro[k]*1.0;
                }else {
                    GPA+=pro[k]*0;
                }
            }
            System.out.printf("%.2f",GPA/count);
        }
    }
}
