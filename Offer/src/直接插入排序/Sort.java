package 直接插入排序;

import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        int[] array ={9,5,2,7,12,2};
        insertSort(array);
        System.out.print(Arrays.toString(array));
    }

    public static void insertSort(int[] array){
        for(int bound = 1;bound < array.length; bound++){
            int tmp = array[bound];
            int cur = bound - 1;

            for(;cur >= 0; cur--){
                if(array[cur] > tmp){
                    array[cur +1] = array[cur];
                }else{
                    break;
                }
            }
            array[cur+1] = tmp;
        }

    }
}
