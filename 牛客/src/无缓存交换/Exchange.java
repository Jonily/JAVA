package 无缓存交换;
import java.util.*;

public class Exchange {
    public static void main(String[] args) {
        int []AB = {1,2};
        int []c = exchangeAB(AB);

    }
    public static int[] exchangeAB(int[] AB) {
      /*AB[0] = AB[0] + AB[1];
      AB[1] = AB[0] -  AB[1];
      AB[0] = AB[0] - AB[1];*/
        AB[0] = AB[0] ^ AB[1];
        AB[1] = AB[0] ^  AB[1];
        AB[0] = AB[0] ^ AB[1];
        return AB;
    }
}
