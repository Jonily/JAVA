import java.util.Scanner;

/**
 * @Description:把一个整型数组转换成字符串. 例如数组 {1, 2, 3} , 返回的字符串为 "[1, 2, 3]"
 * @Author HuangZhuoLin
 * @Date 2020/3/16 22:57
 */

public class changeTo {
    public static void main(String[] args) {
        int[] arrays1 = new int[10];
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入十个数字：");
        for (int i = 0; i < arrays1.length; i++) {
            arrays1[i] = sc.nextInt();
        }
        System.out.println("字符化输出：");
        toString(arrays1);
    }
    public static void toString(int[]a){
        System.out.print("[");
        for(int i = 0;i < a.length;i++){
            System.out.print(a[i]);
            if(i<a.length-1){
                System.out.print(",");
            }
        }
        System.out.print("]");
    }
}
