package 统计连续最长数字串;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int count = 0;
        int max = 0;
        int end = 0;
        for(int i = 0; i< s.length();i++){
            if(s.charAt(i) >='0' && s.charAt(i) <='9'){
                count++;
                if(max < count){
                    max = count;
                    end = i;
                }
            }else{
                count = 0;
            }
        }
        System.out.println(s.substring(end+1-max,end+1));
    }
}
