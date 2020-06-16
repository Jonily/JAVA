package 饥饿的小易;



    /*    4x + 3等于做了两次2*(2x + 1)+1， 8x + 7做了三次。
        从起点开始令x0 = 2*x0 + 1，统计做了多少次2x + 1后模1000000007等于0
        再把次数分解成若干个3与2的和，3的个数加上2的个数最小，不超过100000*/
import java.util.Scanner;

public class Count1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        int count = 0;
        while (x!=0 && count<=300000) {
            x = ((x*2)+1) % 1000000007;
            count++;
        }
        int a = count%3 == 0 ? count/3 : count/3 + 1;
        System.out.println(a > 100000 ? -1:a);
        }

}
