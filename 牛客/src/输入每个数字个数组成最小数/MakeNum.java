package 输入每个数字个数组成最小数;

import java.util.Scanner;

public class MakeNum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String n = in.nextLine();
        String []s = n.split(" ");
        int []num = new int[10];
        String a = "";
        String b = "";
        for (int i = 0; i < s.length ; i++) {
            num[i] = Integer.parseInt(s[i]);
        }
        for (int k = num.length - 1; k >=0 ; k--) {
            if(k == 0){
                int count = num[k];
                while (count != 0){
                    a += k;
                    count--;
                }
            }
            if(num[k] != 0 && k != 0 ){
                int count1 = num[k];
                while (count1 != 0){
                    b += k;
                    count1--;
                }
            }
        }
        StringBuffer A = new StringBuffer(a);
        StringBuffer B = new StringBuffer(b);
        B.insert(B.length() - 1,A);
        B.reverse();
        System.out.println(B);
    }
}
