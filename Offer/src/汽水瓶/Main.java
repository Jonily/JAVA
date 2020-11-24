package 汽水瓶;

import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int a = in.nextInt();
            if(a == 0){
                break;
            }else if(a >=3){
                int k =  Count(a);
                System.out.println(k);
            }else{
                System.out.println(0);

            }

        }
    }

    public static int Count(int a){

        if(a > 3){
            int b = a/3;
            int c = a%3;
            int d = b+c;
            return Count(d)+b;
        }
        if(a == 3 || a == 2){
            return 1;
        }else {
            return 0;
        }

    }
}