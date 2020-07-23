package 数组中出现次数超过一半的数字;

public class Solution {
    public static void main(String[] args) {
        int[] a={1,2,3,2,4,2,5,2,3};
        System.out.println(MoreThanHalfNum_Solution(a));
    }
    public static int MoreThanHalfNum_Solution(int [] array) {

        for (int i = 0; i <array.length ; i++) {
            int count = 0;
            for (int j = 0; j <array.length ; j++) {
                if(array[i]==array[j]){
                    count++;
                }
            }
            if(count> array.length/2){
                return array[i];
            }
        }
        return 0;

    }
}