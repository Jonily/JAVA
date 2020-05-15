package 迭代实现归并排序;

import java.util.Arrays;

public class mergeSort {
    public static void mergeSort(int[] array){
        //gap代表当前每组的元素个数
        for (int gap = 1; gap < array.length; gap *= 2){
            for (int i = 0; i < array.length; i+= 2*gap) {
                //每循环一次相当于把两个长度为gap的相邻数组进行了合并
                //[i,i+gap)    [i+gap.i+2*gap)
                int left = i;
                int mid = i + gap;
                int right = i + 2 * gap;
                if(mid > array.length){
                    mid = array.length;
                }
                if(right > array.length){
                    right = array.length;
                }
                merge(array,left,mid,right);

            }
        }
    }
    //将两个有序列合并成一个有序序列

    private static void merge(int[] array, int left, int mid, int right) {
        //当前有两个有序数组
        //[left,mid)     [mid,right)
        int cur1 = left;
        int cur2 = mid;
        //临时空间要能放下两个数组合并后的结果
        int [] output = new int[right - left];
        int outputIndex = 0;//当前output数组中插入了几个元素

        while (cur1 < mid && cur2 < right){
            if(array[cur1] <= array[cur2]){//必须有=好保证是稳定排序
                //把cur1位置的元素插入output中
                output[outputIndex] = array[cur1];
                cur1++;
                outputIndex++;
            }else {
                output[outputIndex] = array[cur2];
                cur2++;
                outputIndex++;

            }
        }
        while (cur1 < mid ){
            output[outputIndex] = array[cur1];
            cur1++;
            outputIndex++;
        }
        while (cur2 < right ){
            output[outputIndex] = array[cur2];
            cur2++;
            outputIndex++;
        }
        //最后一步把数据从临时空间拷贝到原来的数组中
        for (int i = 0; i < right - left; i++){
            array[left + i] = output[i];
        }

    }
    public static void main(String[] args) {
        int[] a ={9,5,2,7,3,6,4,8};
        mergeSort(a);
        System.out.print(Arrays.toString(a));
    }

}
