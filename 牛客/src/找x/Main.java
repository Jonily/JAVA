package 找x;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            String[] num = new String[n];
            for (int i = 0; i < n; i++) {
                num[i] = in.next();
            }
            String a = in.next();
            for (int j = 0; j < n ; j++) {
                if(a.equals(num[j])){
                    System.out.println(j);
                    return;
                }
            }
                System.out.println("-1");
        }
    }
}
