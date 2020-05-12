package 归并排序;

import java.util.Arrays;

public class MergerSort {
    public static void mergeSort(int[] array) {
        //[0,length)，归并排序采用左闭右开格式，快排左右都闭
        mergeSortHelper(array, 0, array.length);
    }

    private static void mergeSortHelper(int[] array, int left, int right) {
       //[left,right)
        //当left==right区间为空，当left+1=right 区间为1个元素
        if(right - left <= 1){
            //当前区间中有0个或者1个元素，此时不需要进行排序
            return;
        }
        //针对[left,right)，分成两个对等的区间
        int mid = (left + right) / 2;
        //两个区间分别是
        //[left,mid)    [mid,right)
        //通过递归对数组的两个左右区间各自进行排序，最后再进行合并
        mergeSortHelper(array, left, mid);
        mergeSortHelper(array, mid, right);
        //合并
        merge(array, left, mid, right);
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
