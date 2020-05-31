package 插入字符为回文字符;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        System.out.println("输入字符串A：");
        Scanner in = new Scanner(System.in);
        String A = in.next();
        System.out.println("输入字符串B：");
        Scanner in1 = new Scanner(System.in);
        String B = in1.next();
        int i = A.length();
        int count = 0;
        if(A.equals(null)){
            return;
        }else {
            for (int j = 0; j < i+1 ; j++) {
                StringBuffer stringBuffer = new StringBuffer(A);
                stringBuffer.insert(j,B);
                int k =  stringBuffer.length();
                if (justHuiwen(stringBuffer,k)){
                    count++;
                }
            }
            System.out.println("方法数：");
            System.out.println(count);

        }
    }
    public static boolean justHuiwen(StringBuffer stringBuffer, int length){
        for (int i = 0; i < length/2 ; i++) {
            if(stringBuffer.charAt(i) != stringBuffer.charAt(length -1 -i)){
                return false;
            }
        }
        return true;
    }
}
