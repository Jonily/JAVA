package 买苹果;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        System.out.println(bagNum(a));

    }
    public static int bagNum(int a) {
        if(a % 2 != 0){
            return -1;
        }else {
            if (a < 6) {
                return -1;
            } else {
                if (a % 8 != 0) {
                    return 1 + a / 8;
                } else {
                    return a / 8;
                }
            }
        }
    }
}