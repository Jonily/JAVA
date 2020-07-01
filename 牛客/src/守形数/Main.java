package 守形数;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            int a = (int) Math.pow(n,2);
            StringBuffer sb = new StringBuffer(String.valueOf(a));
            String s = String.valueOf(n);
            if(s.equals(sb.substring(1))){
                System.out.println("Yes!");
            }else {
                System.out.println("No!");
            }

        }
    }
}
