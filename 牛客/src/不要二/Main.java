package 不要二;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //输入行
        int m = in.nextInt() ,n = in.nextInt();//输入列
        //＊＊    ＊＊   ＊＊     n == 12
        //＊＊    ＊＊   ＊＊
        //    ＊＊   ＊＊   ＊＊
        //    ＊＊   ＊＊   ＊＊

        //＊＊    ＊＊   ＊＊
        //＊＊    ＊＊   ＊＊
        // m == 6
        //四四行四列为一个周期
        //每个周期的前两行
        int hangCount = (n / 4) * 2 + (n % 4 < 2 ? n % 4 : 2);
        //每个周期的后两行
        int hangCount2 = ((n - 2) / 4) * 2 + (((n - 2) % 4) < 2 ? ((n - 2)%4) : 2) ; //左加右减
        //总共有m/4个这样的行
        int sum = (m / 4) * (hangCount + hangCount2) * 2;
        //如果不能被四整除 则多 1行、2行、3行 三种情况 如果总行数为3 则加三行，下面的三个判断都执行一遍
        if( m % 4 > 0){
            sum += hangCount;
        }
        if(m % 4 > 1){
            sum += hangCount;
        }
        if(m % 4 > 2){
            sum += hangCount2;
        }
        System.out.println(sum);
    }
}
