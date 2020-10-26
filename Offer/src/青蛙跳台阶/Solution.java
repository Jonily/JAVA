package 青蛙跳台阶;

public class Solution {
    public int JumpFloor(int target) {
        int sum = 0 ;
        if(target <= 2){
            return target ;
        }else{
            sum = JumpFloor(target - 1)+JumpFloor(target - 2);
        }
        return sum ;

    }
}