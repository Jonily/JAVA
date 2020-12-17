package 输出所有出栈;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] s = in.next().split(" ");
        int[] num = new int[s.length];
        for (int i = 0; i < s.length ; i++) {
            num[i]= Integer.parseInt(s[i]);
        }



    }
}
