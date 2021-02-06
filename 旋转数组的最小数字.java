class Solution {
    public int minArray(int[] numbers) {
        int low = 0;
        int high = numbers.length-1;
        while(low < high){
            int mid = (low+high)/2;
            if(numbers[high] > numbers[mid]){
                high = mid;
            }else if(numbers[high] < numbers[mid]){
                low = mid+1;
            }else{
                high--;
            }
        }
        return numbers[low];
    }
}