package 二维数组打印;

import java.util.*;

public class Printer {
    public static void main(String[] args) {
        int[][]arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int n = 4;
        System.out.println(Arrays.toString(arrayPrint(arr,n)));
    }
    public static int[] arrayPrint(int[][] arr, int n) {
        int[]num = new int[n*n];
        int flag = 0;
        for (int i = n-1; i >=0; i--) {
            int k = i;
            for (int j = 0; j < n-i; j++) {
                num[flag++] = arr[j][k++];
            }
        }

        for (int i = 1; i <n; i++) {
            int k = i;
            for (int j = 0; j < n-i; j++) {
                num[flag++] = arr[k++][j];
            }
        }
        return num;
    }
}
/*

*/
/**
 *  题意很简单，主要是边界的处理：
 *   1. 沿着主对角线打印，所以每次打印之后x与y都要加1，直到x或y超出边界。
 *   2. 每轮遍历的起始点，是遵循(0,n-1)...（0,0）...（n-1,0）。
 *           也就是y先减小到0，然后x增加到n-1。所以遍历的终止条件是startX>=n。 *
 **//*

        import java.util.*;

public class Printer {
    public int[] arrayPrint(int[][] arr, int n) {
        // write code here
        int[] res = new int[n*n];
        int index = 0;
        int startX = 0;
        int startY = n-1;
        while(startX<n){
            int x = startX;
            int y = startY;
            while(x<n&&y<n)
                res[index++]=arr[x++][y++];
            if(startY>0)
                startY--;
            else
                startX++;
        }
        return res;
    }
}*/
