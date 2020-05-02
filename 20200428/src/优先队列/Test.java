package 优先队列;

import java.util.Comparator;
import java.util.PriorityQueue;
public class Test {

    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1,o2) -> o2 -o1);

        queue.offer(9);
        queue.offer(5);
        queue.offer(2);
        queue.offer(0);
        queue.offer(3);
        queue.offer(4);
        queue.offer(7);

        while (!queue.isEmpty()){
            Integer cur = queue.poll();
            System.out.print(cur+" ");
        }
    }
}
/*
    PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    });

*/
/*static class MyComp implements Comparator<Integer>{
    @Override
    public int compare(Integer o1, Integer o2) {
        //如果认为01优先级比o2高，先出o1 compare返回<0的整数
        //如果认为02优先级比o1高，先出o2 compare返回>0的整数
        //如果一样，返回0
        return o2 - o1;
    }
}*/

//PriorityQueue<Integer> queue = new PriorityQueue<>(new MyComp());