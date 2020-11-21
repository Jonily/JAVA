package 堆;



import java.util.Comparator;
import java.util.PriorityQueue;

public class MyQueue {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        });


                queue.offer(5);
        queue.offer(53);
        queue.offer(5456);
        queue.offer(501651);
        queue.offer(521);

        while (!queue.isEmpty()){
            System.out.println(queue.poll());
        }

    }

    /*static class MyCom implements Comparator<Integer>{*/
    /*    @Override*/
    /*    public int compare(Integer o1, Integer o2) {*/
    /*        return 0;*/
    /*    }*/
    /*}*/
}
