package 奥巴马编程;

import java.util.Scanner;

public class Print {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] a = new String[2];
        String b = in.nextLine();
        a = b.split(" ");
        int n = Integer.valueOf(a[0]);
        for (int i = 0; i < n-1  ; i++) {
            if(i == 0 || i == n - 2){
                for (int j = 0; j < n ; j++) {
                    System.out.print(a[1]);
                }
                System.out.print("\n");
            }else {
                if(i % 2 == 0 && i < n-1){
                    for (int j = 0; j < n  ; j++) {
                        if(j == 0 || j == n - 1){
                            System.out.print(a[1]);
                        }else {
                            System.out.print(" ");
                        }
                    }
                    System.out.print("\n");
                }

            }
        }

    }
}