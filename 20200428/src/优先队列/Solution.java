package 优先队列;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
public class Solution {
    //定义一个类描述数对
    static class Pair{
        public int num1;
        public int num2;
        public int sum;
        public Pair(int num1,int num2){
            this.num1 = num1;
            this.num2 = num2;
            this.sum = num1 + num2;
        }
    }
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if( k<= 0){
            return result;
        }
        //准备一个堆，指定一个比较器对象
        PriorityQueue<Pair> queue = new PriorityQueue<>(new Comparator<Pair>(){//优先队列的类型为Pair
            public int compare(Pair o1,Pair o2){
                return o1.sum - o2.sum;
            }
        });
        //构造出所有的数对，存放到queue之中
        for(int i = 0; i<nums1.length; i++){
            for(int j = 0; j<nums2.length; j++ ){
                queue.offer(new Pair(nums1[i],nums2[j]));
            }
        }
        for(int i = 0;i < k && !queue.isEmpty(); i++){
            Pair cur = queue.poll();
            List<Integer> tmp = new ArrayList<>();
            tmp.add(cur.num1);
            tmp.add(cur.num2);
            result.add(tmp);
        }
        return result;
    }
}