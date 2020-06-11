package 输入一个数每个位上的数进行统计;

import java.util.Scanner;

public class countSeat {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String n = in.nextLine();
        String m = "0123456789";
        int num[] = new int[10];

            for (int j = 0; j < m.length() ; j++) {
                int count = 0;
                for (int i = 0; i < n.length(); i++) {
                    if(n.charAt(i) == m.charAt(j)){
                        count++;
                    }
                }
                num[j] = count;
            }
        for (int k = 0; k < 10;k++) {
            if(num[k] != 0){
                System.out.println(k+":"+num[k]);
            }
        }
    }
}
