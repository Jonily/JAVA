package 插入字符判断回文方法;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str1 = sc.nextLine();
            String str2 = sc.nextLine();
            int len = str1.length();
            int n = 0;
            for (int i = 0; i <= len; i++) {
                String str4 = str1.substring(0, i) + str2 + str1.substring(i);
                String str5 = new StringBuffer(str4).reverse().toString();
                if (str4.equals(str5)) {
                    n++;
                }
            }
            System.out.println(n);
        }
    }
}
