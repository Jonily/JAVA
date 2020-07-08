package 球的半径和体积;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int[]num = new int[6];
            for (int i = 0; i < num.length ; i++) {
                num[i] = in.nextInt();
            }
            double r = 0;
            int a = (int) Math.pow((num[3] - num[0]),2);
            int b = (int) Math.pow((num[4]-num[1]),2);
            int c = (int) Math.pow((num[5]-num[2]),2);
            r = Math.sqrt(a+b+c);
            double V = (4*Math.acos(-1)*Math.pow(r,3))/3;
            System.out.printf("%.3f",r);
            System.out.print(" ");
            System.out.printf("%.3f",V);

        }
        in.close();
    }
}
