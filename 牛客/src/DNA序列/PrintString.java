package DNA序列;

import java.util.Scanner;

public class PrintString {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.nextLine();
            int a = in.nextInt();
            String b = "";
            int max = 0;
            int sign = 0;
            StringBuffer sb = new StringBuffer(str);
            for (int i = 0; i < sb.length() - a ; i++) {
                b = sb.substring(i,i+a);
                int count = 0;
                for (int j = 0; j < b.length() ; j++) {
                    if(b.charAt(j)=='C' ||b.charAt(j)=='G'){
                        count++;
                    }
                }
                if(count > max){
                    max = count;
                    sign = i;
                }
            }
            System.out.println(sb.substring(sign,sign+a));
        }
    }
}
