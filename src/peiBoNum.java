import java.util.Scanner;
public class peiBoNum {
        public static void main(String[] args) {
            System.out.println("输入数字：");
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            System.out.println("裴波那契数列第"+n+"项为：");
            int sum = fun1(n);
            System.out.println(sum);
        }
        public  static int fun1(int n){
            int i = 1 ;
            int j = 1 ;
            int k = 0 ;
            if (n==1||n==2){
                return i ;
            }else{
                for (int a = 3 ; a<=n ; a++){
                    k = i+j ;
                    i=j;
                    j=k;
                }
                return k ;
            }
        }
        public static int fun(int n){
            int i = 0 ;
            if(n==1||n==2){
                return 1 ;
            }else if (n>=3){
                i = fun(n-1)+fun(n-2);
            }
            return i ;
        }
    }
