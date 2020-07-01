package 密码验证合格程序;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()){
            String s = in.nextLine();

            if(justLength(s) && justType(s) && justRepeat(s)){
                System.out.println("OK");
            }else {
                System.out.println("NG");
            }
        }
    }
    private static boolean justLength(String s) {
        if(s == null || s.length()<= 8){
            return false;
        }
        return true;
    }

    private static boolean justType(String s) {
        int bigLetter = 0;
        int smallLetter = 0;
        int number = 0;
        int other = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                number = 1;
                continue;
            }else if(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z'){
                bigLetter = 1;
                continue;
            }else if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z'){
                smallLetter = 1;
                continue;
            }else {
                other = 1;
                continue;
            }
        }
        int count = bigLetter + smallLetter + number + other;
        if(count >= 3){
            return true;
        }else {
            return false;
        }
    }

    private static boolean justRepeat(String s) {
        for (int k = 0; k < s.length()-2 ; k++) {
            String str = s.substring(k,k+3);
            if(s.substring(k+1).contains(str)){
                return false;
            }
      }
        return true;
    }
}
