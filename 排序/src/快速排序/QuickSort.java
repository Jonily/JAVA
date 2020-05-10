package 快速排序;

import java.util.Arrays;

public class QuickSort {
    public static void QuickSort(int[] array){
        //帮助完成递归
        quickSortHelper(array, 0, array.length - 1);
    }

    //[left,right] 前闭后闭区间,针对当前范围进行快排
    private static void quickSortHelper(int[] array, int left, int right) {
        if (left >= right) {
            //区间中有一个元素或者0个元素
            return;
        }
        //返回值表示整理之后，基准值所在位置
        int index = partition(array, left, right);
        //[left,index-1]
        // [index+1,right]
        quickSortHelper(array,left,index - 1);
        quickSortHelper(array, index + 1, right);
    }
    private static int partition(int[] array, int left, int right) {
        int baseValue = array[right];
        int i = left;
        int j = right;
        while (i < j){
            //1、先从左往右找一个大于基准值的元素
            while (i < j && array[i] <= baseValue){
                i++;
            }
            //此时i指向位置要么和j重合，要么就是一个比基准值大的元素
            //2、从右往左找一个小于基准值的元素
            while (i < j && array[j] >= baseValue){
                j--;
            }
            //此时j指向位置要么和i重合，要么就是一个比基准值小的元素
            //3、交换 i 和 j
            if( i < j){
                swap(array, i, j);
            }
        }
        //循环结束i和j重合，把基准值和ij重合位置进行交换
        //此时重合位置的值一定大于基准值
        //1、i++ 触发和j重合，i本来指向大于基准值，i和j交换后，j一定是大于基准值的元素，此时i走到j的位置
        //2、j--触发了和i重合，此时i指向的是一个大于基准值的元素，（第一个while功能），j--就走到了i指的位置
        swap(array, i, right);
        return i;
    }
    private static void swap(int[] array, int i,int j){
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
    public static void main(String[] args) {
        int[] a ={9,5,2,7,4,3,8};
        QuickSort(a);
        System.out.print(Arrays.toString(a));
    }
}
