package 计算逆序对;

import java.util.Scanner;

public class Count {
    public static int count(int[] A, int n) {
        int count = 0;
        for (int i = 0; i < n ; i++) {

            for (int j = i+1; j < n; j++) {
                if(A[i] > A[j]){
                    count++;
                }
            }

        }
        return count;
    }
    public static void main(String[] args) {
        int[] A = {1,2,3,4,5,6,7,0};
        int b = count(A,8);
        System.out.println(b);

    }

}
 class AntiOrder {
    public int count(int[] A, int n) {
        if (A == null || n == 0) {
            return 0;
        }
        return mergeSortRecursion(A, 0, n - 1);
    }
    public static int mergeSortRecursion(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }
        int mid = (l + r) / 2;
//逆序对的总数=左边数组中的逆序对的数量+右边数组中逆序对的数量+左右结合成新的顺序数组时中出现的逆序对的数量；
        return mergeSortRecursion(arr, l, mid) + mergeSortRecursion(arr, mid + 1, r) +
                merge(arr, l, mid, r);
    }
    public static int merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int index = 0;
        int i = left;
        int j = mid + 1;
        int inverseNum = 0;// 新增，用来累加数组逆序对
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[index++] = arr[i++];
            } else {
// 当前一个数组元素大于后一个数组元素时，累加逆序对
                inverseNum += (mid - i + 1);
                temp[index++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[index++] = arr[i++];
        }
        while (j <= right) {
            temp[index++] = arr[j++];
        }
        for (int k = 0; k < temp.length; k++) {
            arr[left++] = temp[k];
        }
        return inverseNum;
    }
}
