package 归并;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] a ={9,5,2,7,3,6,4,8};
        meg(a);
        System.out.print(Arrays.toString(a));
    }
    public static void meg(int[] array){
        megHelper(array,0,array.length);
    }

    public static void megHelper(int[] array,int left,int right){
        if(right - left <= 1){
            return;
        }
        int mid = (left+right)/2;

        megHelper(array,left,mid);
        megHelper(array,mid,right);
        megMake(array,left,right,mid);

    }


    public static void megMake(int[] array,int left,int right,int mid){
        int low = left;
        int high = mid;
        int[] newArray = new int[right - left];
        int index = 0;


        while(low < mid && high < right){
            if(array[low] <= array[high]){
                newArray[index] = array[low];
                low++;
                index++;
            }else{
                newArray[index] = array[high];
                high++;
                index++;
            }
        }

        while(low < mid){
            newArray[index++] = array[low++];
        }
        while(high < right){
            newArray[index++] = array[high++];
        }

        for(int i = 0; i<newArray.length;i++){
            array[i+left] = newArray[i];
        }

    }
}
