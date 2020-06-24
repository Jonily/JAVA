package 最难的问题;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()){
            String s = in.nextLine();
            char[] b = new char[s.length()];
            for (int i = 0; i < s.length() ; i++) {
                if(s.charAt(i)>='A' && s.charAt(i) <= 'Z'){
                    if('E'%s.charAt(i) < 5 ){
                        b[i] = (char)('Z' - 'E'%s.charAt(i));
                    }else {
                        b[i] = (char) (s.charAt(i)-5);
                    }
                }else {
                    b[i] = s.charAt(i);
                }
            }
            String sb = "";
            for (int j = 0; j <b.length ; j++) {
                sb += b[j];
            }
            System.out.println(sb);
        }
    }
}
