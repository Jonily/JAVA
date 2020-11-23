package 寻找第K大;

import java.util.PriorityQueue;

public class Main {
    public static int findKth(int[] a, int n, int K) {
        PriorityQueue<Integer> queue = new PriorityQueue();
        for (int i = 0; i < n; i++) {
            queue.offer(a[i]);
        }
        int[] array = new int[n];
        for (int j = 0; j <n ; j++) {
            array[j] = queue.poll();
        }
        return (array[n-K]);
    }

    public static void main(String[] args) {
        int[]a = {1,3,5,2,2};
        System.out.println(findKth(a, 5, 4));

    }
}
