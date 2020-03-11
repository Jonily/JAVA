import java.util.Scanner;
import java.lang.Math;
public class judgeNum {
    public static void main(String[] args) {
        System.out.println("请输入上限的数字：");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println("100到"+num+"的素数有：");
        fun(num);
        }
        public static void fun (int num){
        int n = 100 ;
        for(n = 100 ; n<= num ; n++){
            int i = 2 ;
            for( i = 2 ; i<=Math.sqrt(n) ; i++){
                if(n%i ==0)
                    break;
            }
            if(i>Math.sqrt(n)) {
                System.out.print(" "+n+" ");
            }
        }
    }
}










    /*
    public static void fun(int num){
        if(num==1){
            System.out.println(num+"不是素数也不是合数！");
        }else{
            int i = 2 ;
            for( i = 2 ; i<=Math.sqrt(num) ; i++){
                if(num%i ==0)
                    break;
            }
            if(i>Math.sqrt(num)) {
                System.out.println(num + "是素数！");
            }else if(1<i && i<=Math.sqrt(num)){
                System.out.println(num+"不是素数！");
            }
        }
    }
}
*/


    /*public static void fun(int num){
        if(num==1){
            System.out.println(num+"不是素数也不是合数！");
        }else{
        int i = 2 ;
        for( i = 2 ; i<=num/2 ; i++){
            if(num%i ==0)
                break;
        }
        if(i>num/2) {
            System.out.println(num + "是素数！");
        }else if(1<i && i<=num/2){
            System.out.println(num+"不是素数！");
        }
    }
  }
}*/






/*
    public static void fun1(int num){
        if(num==1){
            System.out.println(num+"不是素数也不是合数！");
        }
        int i = 2 ;
        for( i = 2 ; i< num ; i++){
         if(num%i ==0)
             break;
            }
        if(i==num) {
            System.out.println(num + "是素数！");
        }else if(1<i && i<num){
            System.out.println(num+"不是素数！");
        }
    }
}*/

  /*int i = 2 ;
          int a = 0 ;
          Scanner sc = new Scanner(System.in);
          System.out.println("请输入一个数字：");
          int num = sc.nextInt();
            if(num==1){
            System.out.println(num+"不是素数也不是合数！");
        }else{
        for(i = 2;i<num ; i++){
          if(num%i==0){
            a++;  // 素数个数加1
           }
    }
        if(a==0){
        System.out.println(num+"是素数");
        }else{
        System.out.println(num+"不是素数");

        }
      }
    }
}*/
