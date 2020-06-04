package 提取字符串中的最长数字字符;

import java.util.Scanner;

public class printString {
    public static void main(String[] args) {
        System.out.println("输入字符串：");
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        System.out.println(printNumofString(a));
    }
    public static String printNumofString(String a){
        int count = 0;
        int max = 0;
        int end = 0;
        for (int i = 0; i < a.length() ; i++) {
            if(a.charAt(i) >= 48 && a.charAt(i) <= 57){
                count++;
                if(max < count){
                    max = count;
                    end = i;
                }
            }else {
                count = 0;
            }
        }
        return a.substring(end +1 - max,end + 1);
    }
}
