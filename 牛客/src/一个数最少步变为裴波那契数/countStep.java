package 一个数最少步变为裴波那契数;

import java.util.Scanner;

public class countStep {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();//输入的数字
        int a = 0;//第一个裴波那契数
        int b = 1;//第二个裴波那契数
        //输入的树一定在两个裴波那契数之间
        //下面循环就是模拟裴波那契数，直到找到一个大于n的一个裴波那契数b
        while (b < n){
            int c = a + b; //前两个裴波那契树之和
            a = b; //新的裴波那契数的小的数
            b = c;//新的裴波那契数的大的数
        }
        int count = ((b - n) < (n - a)) ? (b - n):(n - a);
        System.out.println(count);
    }
}
