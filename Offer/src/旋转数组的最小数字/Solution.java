package 旋转数组的最小数字;

import java.util.ArrayList;
public class Solution {
    public int minNumberInRotateArray(int [] array) {
        int left = 0;
        int right = array.length -1;
        while(left < right){
            int mid = left + (right - left)/2;
            //如果mid的数值大于最右边的数值，则最小的一定在mid的右边
            if(array[mid] > array[right]){
                left = mid + 1;
            } else if(array[mid] == array[right]){//如果中间的等于最右边的那就只能一个一个试
                right = right-1;
            }else{//中间的小于最右边的那最小的就在mid的左边所以将后面的下标往前移
                right = mid;
            }
        }
        return array[left];
    }
}