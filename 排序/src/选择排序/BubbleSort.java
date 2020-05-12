package 选择排序;
//-冒泡;

import java.util.Arrays;

public class BubbleSort {
    public static void BubbleSort(int[] array){
        for(int bound = 0; bound < array.length; bound++){
            for(int cur = 0; cur < array.length - 1; cur++){
                if(array[cur] > array[cur + 1]){
                    swap(array, cur, cur + 1);
                }
            }
        }
    }
    private static void swap (int[] array, int i, int j){
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void main(String[] args) {
        int[] a ={9,5,2,7,1321,0};
        BubbleSort(a);
        System.out.print(Arrays.toString(a));
    }
}
