package 百万富翁问题;

public class GiveMoney {
    public static void main(String[] args) {
        int rich = 10 * 30;
        int pool = 0;
        int giveMoney = 1;
        for (int i = 0; i < 30; i++) {
            pool = pool + giveMoney;
            giveMoney *= 2;
        }
        System.out.println(rich+" "+pool);
    }
}
