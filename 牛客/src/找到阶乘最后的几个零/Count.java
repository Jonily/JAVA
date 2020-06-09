package 找到阶乘最后的几个零;

import java.util.*;

//能被5（5^1）整除的提供1个0
//能被25（5^2）整除的提供2个0
//能被125（5^3）整除的提供3个0
//能被625（5^4）整除的提供4个0
//所以 结果= n/5 + n/25 + n/125 + n/625
public class Count{
    public static void main(String[] args){
        Scanner in = new Scanner (System.in);
        int n = in.nextInt();
        int count = 0;
        for(int i = n; i >=5; i--){
            int tmp = i;
            while (tmp % 5 ==0){
                count++;
                tmp /= 5;
            }
        }
        System.out.println(count);
    }
}