import java.util.Scanner;

public class BigNum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();//输入要进行阶乘的数字
        int []ret = new int[1000000];//开辟数组空间
        int tmp = 0;//用来临时存放每次每一位相乘再加上进位数所得到的结果
        int seat = 1;//记录位数，最开始一定有一位，即1也就是数组的下标数
        int count =0;//计数
        ret[0] = 1;//使数组的第一位为1
        for (int i = 2; i <= n ; i++) {//第一位为1，所以后面的乘从2开始
            int num = 0;
            for (int j = 0; j < seat ; j++) {
                 tmp = ret[j] * i + num;//临时存放每次每一位相乘再加上进位数所得到的结果
                 ret[j] = tmp % 10;//取低位数字
                num = tmp / 10;//num中放每次的进位
            }
            while (num != 0){
                ret[seat] = num % 10;//相当于向后扩充一位，如果num大于10，则取个位
                num = num / 10; //num大于10，则取num需要的进位
                seat++;//位数加一，用来存放更高位
            }
        }
        for(int i = 0;i < ret.length;i++){
            if(ret[i] == 0){
                count++;
            }else {
                break;
            }
        }
        System.out.println(count);
    }
}
