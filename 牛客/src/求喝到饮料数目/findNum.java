package 求喝到饮料数目;

import java.util.Scanner;

public class findNum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int i = 0;
        int a = 0;
        int b = 0;
        while (i < 10) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            a = in.nextInt();
            if( a== 0){
                break;
            }
            i++;
             b = findNum(a);
            System.out.println(b);
        }
    }
    public static int findNum(int num){
        if(num == 3 || num == 2){
            return 1;
        }
        int count = 0;
            count = num/3;
            num = count + num % 3;
        count += findNum(num);
            return count;
    }
}
