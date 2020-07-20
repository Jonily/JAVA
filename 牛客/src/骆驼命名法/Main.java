package 骆驼命名法;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String s = in.next();
            for (int i = 0; i < s.length() ; i++) {
                if(s.charAt(i)=='_'){
                    s = s.substring(0,i)+String.valueOf(s.charAt(i+1)).toUpperCase()+s.substring(i+2);
                }
            }
            System.out.println(s);
        }
    }
}
