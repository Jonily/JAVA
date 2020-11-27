package 删除公共字符;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String s1 = in.nextLine();
        String s2 = in.nextLine();
        for(int i = 0;i<s2.length();i++){
            s1 = s1.replaceAll(String.valueOf(s2.charAt(i)),"");
        }
        System.out.println(s1);

    }
}
