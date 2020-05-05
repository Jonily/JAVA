package 折半插入;

import java.util.Arrays;

public class bsInsertSort {
    public static void bsInsertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int v = array[i];
            int left = 0;
            int right = i;
// [left, right)
// 需要考虑稳定性
            while (left < right) {
                int mid = (left + right) / 2;
                if (v >= array[mid]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
        // 搬移
           for (int j = i; j > left; j--) {
            array[j] = array[j - 1];
           }
        array[left] = v;
        }
    }
    public static void main(String[] args) {
        int[] a ={9,5,2,7};
        bsInsertSort(a);
        System.out.print(Arrays.toString(a));
    }
}

