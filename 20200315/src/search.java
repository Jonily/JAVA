/**
 * @Description:数组冒泡，倒置
 * @Author HuangZhuoLin
 * @Date 2020/3/15 15:25
 */

import java.util.Arrays;
public class search {
    public static void main(String[] args) {
        int[]array = new int []{4,8,3,1};
         bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void bubbleSort(int[] array){
        int i = 0 ;
        int j = 0 ;
        boolean bit = false;
        for (i = 0 ;i<array.length-1;i++){//趟数
            for(j = 0 ; j<array.length-1-i;j++){
                if(array[j]>array[j+1]){
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                bit = true;
                }
            }
        }
        if(bit == false)
        return ;
        System.out.println(Arrays.toString(array));
    }
}

/*
public class search {
    public static void main(String[] args) {
        int[]array = new int []{1,2,3,4};
        int n = 4;
        int key = binarySearch(array,n);
        System.out.println(key);
    }

    public static int binarySearch(int[] array,int key){
        int mid = 0 ;
        int left = 0 ;
        int right = array.length-1;
        while(left<=right){
            mid = (left+right)/2;
            if(array[mid]<key){
                left = mid+1;
            }else if (array[mid]>key){
                right = mid-1;
            }else {
                return mid;
            }
        }
        return -1;
    }
}
*/
 /*public static void reverse(int[] array){
     int left = 0 ;
     int tmp = 0 ;
     int right = array.length-1;
    while(left<right){
        tmp = array[right];
        array[right] = array[left];
        array[left] = tmp ;
        left++;
        right--;
    }

 }*/