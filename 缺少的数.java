class Solution {
    public int missingNumber(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        while(low < high){
            int mid = (low+high)/2;
            if(nums[mid] != mid ){
                high = mid;
            }else{
                low= mid+1;
            }
        }
         return low == nums.length - 1 && nums[low] == low ? low + 1 : low;

       
    
    }
}