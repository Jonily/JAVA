package 计算日期到天数转换;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        while (in.hasNext()){
            int year = in.nextInt();
            int month = in.nextInt();
            int day = in.nextInt();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i <12 ; i++) {
               if(i<7){
                   if(i==1){
                       list.add(28);
                   }else if (i%2!=0){
                       list.add(30);
                   }else {
                       list.add(31);
                   }
               }else {
                   if (i%2!=0){
                       list.add(31);
                   }else {
                       list.add(30);
                   }
               }
            }
            System.out.println(iConverDateToDay(year,month,day,list));
        }
    }
    public static int iConverDateToDay(int year, int month, int day,List list) {
        int outDay = 0;
        if(month>12 || month<1 || day>31 || day<1 || year<1){
            return -1;
        }else {
            if((year%100!=0&&year%4==0) || (year%100==0&&year%400==0)){
                list.remove(1);
                list.add(1,29);
                for (int i = 0; i < month-1 ; i++) {
                    outDay+= (int) list.get(i);
                }
                return outDay+day;
            }else {
                for (int i = 0; i < month-1 ; i++) {
                    outDay+= (int) list.get(i);
                }
                return outDay+day;
            }
        }
    }
}
