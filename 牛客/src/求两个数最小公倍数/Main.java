package 求两个数最小公倍数;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int a = in.nextInt();
            int b = in.nextInt();
            if(justNum(a) && justNum(b)){
                System.out.println(a*b);
            }else {
                int m = getNum(a,b);
                System.out.println(m*(a/m)*(b/m));
            }
        }
    }
    public static boolean justNum(int a){
        if(a <= 3){
            return true;
        }else {
            for (int i = 2; i < a ; i++) {
                if(a % i == 0){
                    return false;
                }
            }
        }
        return true;
    }
    public static int getNum(int a,int b){
        int k = 0;
        for (int j = 1; j <= a; j++) {
            if(a % j == 0 && b % j ==0 ){
                k = j;
            }
        }
        return k;
    }
}
