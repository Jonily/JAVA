package 机器人走方格1;

import java.util.*;

public class Robot {

    //机器人在X*Y的矩阵中走，每一步都有两种选择：要么向下、要么向右。
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x= in.nextInt();
        int y = in.nextInt();
        int count = countWays(x,y);
        System.out.println(count);

    }
    public static int countWays(int x, int y) {
        //当整个矩阵只有一行 或 一列的时候只有一种走法。
        if(x == 1){
            return 1;
        }
        if(y == 1){
            return 1;
        }else {
            return countWays(x - 1,y)+ countWays(x,y - 1);
            //如果向下走，问题就变成：求(X-1)*Y矩阵中机器人的走法；
            //如果向右走，问题就变成：求X*(Y-1)矩阵中机器人的走法；
        }

    }
}