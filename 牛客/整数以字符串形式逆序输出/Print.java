package 整数以字符串形式逆序输出;

import java.util.Scanner;

public class Print {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String sb = "";
        sb = String.valueOf(n);
        StringBuffer bf = new StringBuffer(sb);
        bf.reverse();
        System.out.println(bf);
    }
}
