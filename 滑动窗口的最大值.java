class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length==0 || k==0){
            return new int[0];
        }
        int[] ret = new int[nums.length+1-k];
        int index = 0;
        Deque<Integer> deque = new LinkedList<>();
        //在窗口未形成时
        for(int i = 0; i < k;i++){
            while(!deque.isEmpty() && nums[i]>deque.peekLast() ){
                deque.removeLast();
            }
            deque.addLast(nums[i]);
        }
        //先将队首放入数组
        ret[index++] = deque.peekFirst();

        //窗口形成
        for(int i = k; i< nums.length;i++){
            if(nums[i-k] == deque.peekFirst()){
                deque.removeFirst();
            }
            while(!deque.isEmpty() && nums[i]>deque.peekLast()){
                deque.removeLast();
            }
            deque.addLast(nums[i]);
            ret[index++] = deque.peekFirst();
        }
        return ret;
    }
}