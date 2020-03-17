import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description: 调整数组顺序使得奇数位于偶数之前。调整之后，不关心大小顺序。
 * @Author HuangZhuoLin
 * @Date 2020/3/17 10:39
 */

public class sequenceArrays {
    public static void main(String[] args) {
        int[] arrays1 = new int[10];
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入十个数字：");
        for (int i = 0; i < arrays1.length; i++) {
            arrays1[i] = sc.nextInt();
        }
        fun(arrays1);
    }
    public static void fun(int[] a){
        int left = 0 ;
        int tmp = 0;
        int right = a.length-1;
        while (left<right){
            while(left<right && a[left]%2!=0){
                left++;
            }
            while(left<right && a[right]%2==0){
                right--;
            }
            tmp = a[left];
            a[left] = a[right];
            a[right] = tmp;
        }
        System.out.print(Arrays.toString(a));
    }
}
