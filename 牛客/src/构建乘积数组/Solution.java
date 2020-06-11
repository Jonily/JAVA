package 构建乘积数组;

//b0  1 a1 a2 a3 a4 a5 ....an-1
//b1  a0 1 a2 a3 a4 a5 ....an-1
//b2  a0 a1 1 a3 a4 a5 ....an-1
//b3  a0 a1 a2 1 a4 a5 ....an-1
//...
//bn-2 a0 a1 a2 a3 a4 ....1 an-1
//bn-1 a0 a1 a2 a3 a4  .......1
import java.util.ArrayList;
public class Solution {
    public static void main(String[] args) {

    }
    public int[] multiply(int[] A) {
        int length = A.length;
        int []B = new int[length];
        if(length != 0){
            B[0] = 1;
            //计算左下角的乘积
            for (int i = 1; i < length ; i++) {
                B[i] = B[i - 1] * A[i - 1];
            }
            //计算左上角
            int tmp = 1;
            for (int j = length - 2; j >= 0 ; j--) {
                tmp = tmp * A[j + 1];
                B[j] *= tmp;
            }
        }
        return B;
    }
}