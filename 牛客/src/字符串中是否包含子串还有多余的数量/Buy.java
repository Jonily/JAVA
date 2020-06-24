package 字符串中是否包含子串还有多余的数量;

import java.util.Scanner;

public class Buy {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()){
            String s = in.nextLine();
            String b = in.nextLine();
            StringBuffer sb = new StringBuffer(s);
            String c = "";
            for (int i = 0; i < b.length(); i++) {
                for (int j = 0; j < sb.length() ; j++) {
                    if (b.charAt(i) == sb.charAt(j)) {
                        sb.deleteCharAt(j);
                        c += b.charAt(i);
                        break;
                    }
                }
            }
            if(c.length() == b.length()){
                System.out.println("yes"+" "+ sb.length());
            }else {
                System.out.println("No"+" "+(b.length()-c.length()));
            }
        }
    }
}
