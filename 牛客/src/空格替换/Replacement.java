package 空格替换;

import java.util.*;

public class Replacement {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        String a ="Mr John Smith ";
        int b = 13;
        System.out.println(replaceSpace(a,b));
    }
    public static String replaceSpace(String iniString, int length) {
        StringBuffer sb = new StringBuffer(iniString);
        for (int i = 0; i < sb.length() ; i++) {
            if(sb.charAt(i)==' '){
                sb.replace(i,i+1,"%20");
            }

        }
        String a = String.valueOf(sb);
        return a;

    }
}