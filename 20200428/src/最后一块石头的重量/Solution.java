package 最后一块石头的重量;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Description:
 * @Author HuangZhuoLin
 * @Date 2020/5/2 21:35
 */

public class Solution {
    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        if(stones.length == 0){
            return 0;
        }
        for(int i = 0;i<stones.length;i++){
            queue.offer(stones[i]);
        }
        while (queue.size()>1){
            int y = queue.poll();
            int x = queue.poll();
            int z = 0;
            if(x == y && queue.size() == 0){
                return 0;
            }
            if(x != y){
                 z = y - x;
                queue.offer(z);
            }
        }
        int k = queue.poll();
        return k;
    }
}
