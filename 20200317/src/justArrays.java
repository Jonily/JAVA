/**
 * @Description: 给定一个整型数组, 判定数组是否有序（递增）
 * @Author HuangZhuoLin
 * @Date 2020/3/17 9:09
 */
import java.util.Scanner;
public class justArrays {
    public static void main(String[] args) {
        int[] arrays1 = new int[10];
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入十个数字：");
        for (int i = 0; i < arrays1.length; i++) {
            arrays1[i] = sc.nextInt();
        }
        fun(arrays1);
    }
    public static boolean fun(int[]a){
        for(int i = 0;i < a.length-1;i++){
            if(a[i]>a[i+1]){
                System.out.println("数组在第"+(i+1)+"个是无序的！");
                return false;
             }
          }
        System.out.println("数组是有序的！");
        return true;
    }
}
