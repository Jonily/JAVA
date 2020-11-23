package 快排;

import java.util.Arrays;

public class QuickSort {

    public static void QuickSort(int[] array){
        quickHelper(array,0,array.length-1);
    }
    public static void quickHelper(int[] array,int left,int right){
        if(left >= right){
            return;
        }

        int index = find(array,left,right);
        quickHelper(array,left,index-1);
        quickHelper(array,index+1,right);
    }

    public static int find(int[] array,int left,int right){
        int val  = array[left];
        int i = left;
        int j = right;

        while(i< j){
            while( i<j && array[j] >= val ){
                j--;
            }
            while( i<j && array[i] <= val){
                i++;
            }
            if(i < j){
                swap(array,i,j);
            }
        }
        swap(array,i,left);
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
