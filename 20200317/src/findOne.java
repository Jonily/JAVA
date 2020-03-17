

/**
 * @Description: 有一组数据，只有一个数字是出现一次，其他是两次，请找出这个数字.
 * @Author HuangZhuoLin
 * @Date 2020/3/17 17:50
 */
import java.util.Scanner;
public class findOne {
    public static void main(String[] args) {
        int[] arrays1 = new int[10];
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入十个数字：");
        for (int i = 0; i < arrays1.length; i++) {
            arrays1[i] = sc.nextInt();
        }
       int ret = fun(arrays1);
        System.out.println("只出现一次的数字为："+ret);

    }
    public static int fun(int[] a){
        int i = 0;
        int ret = 0;
        for(i = 0;i<a.length;i++){
            ret^=a[i];
        }
        return ret;
    }
}
