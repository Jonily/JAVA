package com.bit.TestDemo;

/**
 * @Description:
 * @Author HuangZhuoLin
 * @Date 2020/4/2 10:29
 */

public class InterClass {
    public static void main(String[] args) {
        String IDnum = "612323199902126123";
        //System.out.println("该生入学年份为"+getyear(num)+"年");
        System.out.println(getBirthStr(IDnum));

    }
    public static String getBirthStr(String IDnum){
        String year = IDnum.substring(6,10);
        String month = IDnum.substring(10,12);
        String day = IDnum.substring(12,14);
        StringBuffer str = new StringBuffer(year);
        str.append("年");
        if(month.charAt(0)=='0'){
            str.append(month.charAt(1));
        }else {
            str.append(month);
        }
        str.append("月");
        if(day.charAt(0)=='0'){
            str.append(day.charAt(1));
        }else {
            str.append(day);
        }
        str.append("日");
        return (year+month+day);


    }
   /* public static boolean checkIsDx (String num){
        char[]a = new char[2];
        for(int i = 4; i < a.length; i++){
            a[i] = num.charAt(i);
        }
        String Dx = new String(a);
        boolean flag = Dx.equals("06");
        return flag;
    }*/


}
    /*public static boolean getyear(String num){
        char[]A = new char[4];
        for(int i = 0; i < A.length; i++){
            A[i] = num.charAt(i);
        }
        String year = new String(A);//用字符数组创建字符串对象
        return Integer.parseInt(year);//用整形的包将字符串转化为整型
         }*/
        //根据学号判断是否是电信学院学生

