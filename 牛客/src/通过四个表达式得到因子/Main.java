package 通过四个表达式得到因子;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            int d = in.nextInt();
                    int A = (a+c)/2;
                    int B = (b+d)/2;
                    int C = (d-b)/2;
                    if( A-B !=a || B-C != b || A+B != c || B+C != d){
                        System.out.println("No");
                    }else {
                        System.out.println(A+" "+B+" "+C);
                    }
        }
    }
}
