package 洗牌;
/**
 * 每次读取一个数之后，算出他经过k次洗牌后的位置，只用一个长度为2n数组用来输出
 * 根据当前数的位置，可以算出经过一次洗牌后的位置
 * 如果当前数小于等于n（即在左手），则他下次出现的位置是 2*当前位置-1
 * 如果当前位置大于n（即在右手）,则他下次出现的位置是 2*（当前位置 - n）
 *
 */

import java.util.Scanner;

public class WashPork {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int groups = in.nextInt();//输入组数
        while (groups-- > 0){//每一组循环一次
            int n = in.nextInt();//输入牌数一半
            int k = in.nextInt();//洗牌间隔
            int []res = new int[2*n];//定义一个二倍牌数
            for (int i = 0; i < 2*n; i++) {
                int tmp = i + 1;//从1开始
                for (int j = 0; j < k ; j++) {
                    if(tmp <= n){//如果小于等于n，在左手
                        tmp = 2*tmp - 1;//下次出现的位置为2*当前位置-1
                    }else {//大于n，在右手
                        tmp = 2*(tmp - n);//下次出现的位置为2*（当前位置-n）
                    }
                }
                res[tmp - 1 ] = in.nextInt();
            }
                //输出
            if(res.length> 0){
                System.out.print(res[0]);
            }
                for(int p = 1;p < 2*n; p++){
                    System.out.print(" "+res[p]);
                }
                System.out.println();
        }
    }
}