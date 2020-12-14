package DNA序列;

import java.util.Scanner;

public class PrintString {
    /*public static void main(String[] args) {
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
    }*/
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            String a = in.nextLine();
            int b = in.nextInt();
            int sign = 0;
            int max = 0;
            for(int i =0; i<a.length()-b-1;i++ ){
                int count = 0;
                String s = a.substring(i,i+b);
                for (int j = 0; j < s.length(); j++) {

                    if(s.charAt(j)=='G'||s.charAt(j)=='C'){
                        count++;
                    }
                }
                if(max < count){
                    max = count;
                    sign = i;
                }
            }
            System.out.println(a.substring(sign,sign+b));
        }
    }
}
