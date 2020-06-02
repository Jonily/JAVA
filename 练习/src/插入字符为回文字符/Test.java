package 插入字符为回文字符;

import java.util.*;
import java.lang.StringBuffer;

public class Test {
    public static void main(String[] args) {
        System.out.println("输入字符串A：");
        Scanner in = new Scanner(System.in);
        String A = in.nextLine();
        System.out.println("输入字符串B：");
        Scanner in1 = new Scanner(System.in);
        String B = in.nextLine();
                //获取第一行字符串的长度
                int length = A.length();
                //计数
                int count=0;
                for(int i=0;i< length;i++){
                    StringBuffer sb = new StringBuffer();
                    sb=sb.append(A).insert(i,B);
                    if(justHuiwen(sb)){
                        count++;
                    }

                }
                System.out.print(count);
            }
    public static boolean justHuiwen(StringBuffer C){
        int i=0;
        int j=C.length()-1;
        while(i<j){
            if(C.charAt(i)!=C.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
 /* sb2=sb2.append(A).insert(i,B).reverse();
                    String s3=sb.toString();
                    String s4=sb2.toString();
                    //System.out.println(s3+"/"+s4+"/"+s3.equals(s4));
                    if(s3.equals(s4)){
                        count++;
                    }*/
