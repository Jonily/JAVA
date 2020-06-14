package 下厨房;

import java.util.HashSet;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        HashSet<String> hashSet = new HashSet<>();
        while (in.hasNextLine()) {
            // 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            String s = in.nextLine();
            String[] a = new String[50];
            a = s.split(" ");
            for (int j = 0; j < a.length; j++) {
                hashSet.add(a[j]);
            }
            System.out.println(hashSet.size());
        }

    }
}