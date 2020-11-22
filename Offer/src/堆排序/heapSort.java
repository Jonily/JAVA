package 堆排序;

import java.util.Arrays;

public class heapSort {
    public static void Sort(int[] array){
        createHeap( array);
        int heapSize = array.length;
        for (int i = 0; i < array.length; i++) {
            swap1(array,0,heapSize-1);
            heapSize--;
            shfitDown(array,heapSize,0);
            
        }
    }

    private static void createHeap(int[] array) {
        for (int i = (array.length -1-1)/2; i >=0  ; i--) {
            shfitDown(array,array.length,i);

        }
    }

    private static void shfitDown(int[] array, int length, int i) {
        int parent = i;
        int child = 2*parent+1;

        while (child < length){
            if((child+1)<length && array[child+1] > array[child]){
                child = child+1;
            }
            if(array[child] > array[parent]){
                swap1(array,child,parent);

            }else {
                break;
            }

            parent = child;
            child = 2*parent+1;
        }

    }

    private static void swap1(int[] array, int child, int parent) {
        int tmp = array[child];
        array[child] = array[parent];
        array[parent] = tmp;
    }
    public static void main(String[] args) {
        int[] a ={9,5,2,7,4,3,8};
       Sort(a);
        System.out.print(Arrays.toString(a));
    }
}
