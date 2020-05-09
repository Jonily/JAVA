package 堆排序;

import java.util.Arrays;

public class HeapSort {
    public static void heapSort(int[] array){
        createHeap(array);
        int headSize = array.length;
        for(int i = 0; i < array.length; i++){
            swap(array, 0, headSize - 1);
            headSize--;
            shiftDown(array, headSize, 0);
        }
    }
    private static void createHeap(int[] array){
        for(int i = (array.length - 1 - 1)/2; i >= 0; i-- ){
            shiftDown(array, array.length, i);
        }
    }
    private static void shiftDown(int[] array, int size, int index){
        int parent = index;
        int child = 2 * parent + 1;
        while (child < size){
            if(child + 1 < size && array[child+1] > array[child]){
                child = child + 1;
            }
            if(array[parent] < array[child]){
                swap(array,parent,child);
            }else {
                break;
            }
            parent = child;
            child = 2 * parent + 1;
        }
    }
    private static void swap(int[] array, int i,int j){
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void main(String[] args) {
        int[] a ={9,5,2,7,4,3,8};
        heapSort(a);
        System.out.print(Arrays.toString(a));
    }
}

