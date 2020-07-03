package 奇偶校验;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()){
            String s1 = in.nextLine();
            for (int i = 0; i < s1.length() ; i++) {
                ODD((s1.charAt(i)));
            }
        }
    }

    private static void ODD(char s) {
        String m = Integer.toBinaryString((int) s) ;
        while(m.length()<7){
            m = "0" + m;
        }
        int count = 0;
        for (int j = 0; j < m.length() ; j++) {
            if(m.charAt(j)=='1'){
                count++;
            }
        }
        if(count % 2 ==0){
            m = "1"+m;
        }else {
            m = "0"+m;
        }
        System.out.println(m);
    }
}
