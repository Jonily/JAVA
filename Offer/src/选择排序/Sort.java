package 选择排序;

import java.util.Arrays;

public class Sort {
    public static void Sort(int[] array){
        for(int bound = 0;bound<array.length;bound++){
            for(int cur = bound + 1; cur < array.length;cur++){
                if(array[bound] < array[cur]){
                    swap(array,bound,cur);
                }
            }
        }
    }

    public static void swap(int[] array, int bound, int cur){
        int tmp = array[cur];
        array[cur] = array[bound];
        array[bound] = tmp;

    }
    public static void main(String[] args) {
        int[] a ={9,5,2,7,3};
        Sort(a);
        System.out.print(Arrays.toString(a));
    }
}
