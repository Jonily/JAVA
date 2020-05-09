package 希尔排序;

import java.util.Arrays;

/**
 * @Description:
 * @Author HuangZhuoLin
 * @Date 2020/4/30 21:24
 */

public class shellSort {
    public static void shellSort(int[] array){
        int gap = array.length / 2;
        while (gap > 1){
           insertSortGap(array,gap);
           gap = gap / 2;
        }
        insertSortGap(array,1);
    }

    private static void insertSortGap(int[] array, int gap) {
        //从每组下标为1开始
        for(int bound = gap; bound < array.length;bound++){
            int tmp = array[bound];
            int cur = bound - gap;
            for(;cur >= 0; cur -= gap){
                if(array[cur] > tmp){
                    //进行搬运，把cur位置的元素搬到cur+gap位置
                    array[cur + gap] = array[cur];
                }else {
                    break;
                }
                array[cur + gap] = tmp;
            }
        }

    }

    public static void main(String[] args) {
        int[] a ={1,6,9,52,12346,46548446};
        shellSort(a);
        System.out.print(Arrays.toString(a));
    }


}
