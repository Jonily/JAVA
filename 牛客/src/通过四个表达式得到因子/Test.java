package 通过四个表达式得到因子;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System. in);
        while (in. hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int a = in.nextInt( );
            int b = in.nextInt( );
            int c = in.nextInt( );
            int d = in.nextInt( );
            if(((a+c)%2==0) && ((b+d)%2==0)&& ((d-b)%2==0)){
                int A = (a+c)/2;
                int B = (b+d)/2;
                int C = (d-b)/2;
                if(((A >= 0) && (B >= 0) && (C >= 0))  ){
                    System. out.println(A+" "+B+" "+C);
                }else {
                    System.out. println( "No");
                }
            }else {
                System.out. println( "No");
            }
        }
    }
}

