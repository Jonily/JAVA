package my.Test;

import java.util.Scanner;

/**
 * @Description:
 * @Author HuangZhuoLin
 * @Date 2020/4/7 17:36
 */

public class Test {
    public static void main(String[] args) {
      /*  String s1="abc"+"def";//1
        String s2=new String(s1);  //2
        if(s1.equals(s2))//3
            System.out.println(".equals succeeded");//4
        if(s1==s2)//5
            System.out.println("==succeeded");//6
        String str = "Hello";
        str = "h" + str.substring(4);
        System.out.println(str);*/
        String str1 = "helloworld" ;
        char[] data = str1.toCharArray() ;
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i]+" "); }
        // 字符数组转为字符串
     System.out.println(new String(data));// 全部转换
     System.out.println(new String(data,4,3)); // 部分转换
    }
}
