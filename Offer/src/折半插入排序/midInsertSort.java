package 折半插入排序;

import java.util.Arrays;

public class midInsertSort {
    public static void Sort(int[] array){
        for (int i = 1; i < array.length ; i++) {
            int val = array[i];
            int left = 0;
            int right = i;

            while (left < right){
                int mid = (left + right)/2;
                if(array[mid] <= val){
                    left = mid +1;

                }else {
                    right = mid;
                }
            }

            for (int j = i; j > left ; j--) {
                array[j] = array[j-1];
            }
            array[left] = val;

        }
    }
    public static void main(String[] args) {
        int[] a ={9,5,2,7};
      Sort(a);
        System.out.print(Arrays.toString(a));
    }
}
