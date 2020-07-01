package 整数与IP地址间的转换;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String[] ip = in.next().split("\\.");
            String result ="";
            for (int i = 0; i <ip.length ; i++) {
                String num = Long.toBinaryString(Long.parseLong(ip[i]));
                while(num.length()<8){
                    num = "0" + num;
                }
                result+=num;
            }
            String b = in.next();
            String s = Long.toBinaryString(Long.parseLong(b));
            StringBuffer sb = new StringBuffer(s);
            String[] sp = new String[sb.length()/8];
            String str = "";
            int j = 0;
            for (int i = sb.length(); i >8 ; i-=8) {
                    sp[j] = String.valueOf(Long.parseLong(sb.substring(i-8,i),2));
                    j++;
            }
            String str1 = "";
            if(sp.length == 4){
                str = String.valueOf(Long.parseLong(sb.substring(0,8),2));
                for (int k = sp.length-2; k >=0 ; k--) {
                    str1+=("."+sp[k]);
                }
            }else {
                str = String.valueOf(Long.parseLong(sb.substring(0,sb.length()-sp.length*8),2));
                for (int k = sp.length-1; k >=0 ; k--) {
                    str1+=("."+sp[k]);
                }
            }
            str+=str1;
            System.out.println( Long.parseLong(result.toString(),2));
            System.out.println(str);
        }
    }
}
