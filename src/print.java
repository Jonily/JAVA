import java.util.Scanner;
import java.lang.Math;
public class print {
    public static void main(String[] args) {
        System.out.println("输入范围（上限）：");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println("符合条件的有：");
        print1(num);
    }
    public static void print1(int num){
        for(int i = 0 ; i<= num ; i++){
            int count = 0 ;
            int tmp = i ;
            while(tmp!=0){
                count++ ;
                tmp/=10 ;
            }
            tmp = i ;
            long sum = 0L ;
            while(tmp!=0){
                sum+= Math.pow (tmp%10,count);
                tmp/=10;
            }
            if(sum==i){
                System.out.print(" "+i+" ");
            }
        }
    }
}
