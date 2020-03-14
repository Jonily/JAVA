import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
public class biClass {
    public static void main(String[] args) {
        int [] array =  {1,2,3};
        int [] ret = mycopy(array);
        System.out.println(Arrays.toString(ret));
    }
    public static int [] mycopy(int [] array){
          int [] ret = new int[array.length];
          int i = 0 ;
          for (i = 0 ; i<array.length;i++){
              ret[i] = array[i];
          }
          return ret;
    }





    /*
        System.out.println("请输入数字：");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        fun(num);
    }
    public static void fun(int num){
        int i = 0 ;
        while(num!=0){
            i = num%10;
            num=num/10;
            System.out.print(" "+i+" ");

        }
    }
}
*/
    }