package 木棒拼图;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Comparator<Integer> cmp = new Comparator<Integer>() {
            public int compare(Integer e1, Integer e2) {
                return e2 - e1;
            }
        };
        PriorityQueue<Integer> queue = new PriorityQueue<>(cmp);

        while (in.hasNext()){
            int n = in.nextInt();
            int shape =0;

            for (int i = 0; i < n ; i++) {
               int just = in.nextInt();
                int l = in.nextInt();
                if(just == 1){
                    queue.add(l);
                }else {
                    queue.remove(l);
                }
                shape = queue.peek();
                List<Integer> list = new ArrayList<>(queue);
                if(list.size()>=3){
                    int len = 0;
                    for (int j = 0; j < list.size() ; j++) {
                        len+= list.get(j);
                    }
                    if((len-shape)>shape){
                        System.out.println("Yes");
                    }else {
                        System.out.println("No");
                    }
                }else {
                    System.out.println("No");
                }
            }
        }
    }
}
