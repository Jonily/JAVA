package 统计每个月兔子的总数;

import java.util.Scanner;

public class GetCount {
    /**
     * 统计出兔子总数。
     *
     * @return 兔子总数
     */
    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        while (in.hasNext()){
            System.out.println( getTotalCount(in.nextInt()));
        }

    }
    public static int getTotalCount(int monthCount) {
        if(monthCount < 3){
            return 1;
        }else {
            int a = 1;
            int b = 1;
            int c = 0;
            while (monthCount >=3){
                c = a + b;
                a = b;
                b = c ;
                monthCount --;
            }
            return c;
        }
    }
}

/*

import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int monthCount = in.nextInt();
            System.out.println(getTotalCount(monthCount));
        }
        in.close();
    }

    public static int getTotalCount(int monthCount){
        if(monthCount==1 || monthCount==2){
            return 1;
        }

        return getTotalCount(monthCount-1)+getTotalCount(monthCount-2);
    }
}
*/

