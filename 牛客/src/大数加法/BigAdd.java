package 大数加法;

import java.math.BigInteger;
import java.util.Scanner;

public class BigAdd {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            String addend = in.nextLine();
            String augend = in.nextLine();
            String sum = AddLongInteger(addend,augend);
            System.out.println(sum);
        }
    }
    public static String AddLongInteger(String addend, String augend){
        BigInteger bigInteger1 = new BigInteger(addend);
        BigInteger bigInteger2 = new BigInteger(augend);
        BigInteger sum = bigInteger1.add(bigInteger2);
        String sum1 = String.valueOf(sum);
        return sum1;
    }
}
