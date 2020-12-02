package 找出n个数里最小的k个;
import java.util.*;

import java.util.*;

public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if((input == null)|| (k==0) || (k>input.length)){
            return list;
        }
        int[] num = new int[input.length];
        for (int i = 0; i < input.length ; i++) {
            num[i] = input[i];
            // k = num[a.length-1];
        }
        Arrays.sort(num);
        for (int i = 0; i < k; i++) {
            list.add(num[i]);
        }
        return list;
    }
}/*
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class FindK {
       public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String n = in.nextLine();
        String []a = null;
        a = n.split(" ");
        int k = 0;
        int []num = new int[a.length];
        for (int i = 0; i < a.length ; i++) {
            num[i] = Integer.parseInt(a[i]);
            k = num[a.length-1];
        }
        Arrays.sort(num,0,num.length-1);
        for (int i = 0; i < k; i++) {
            System.out.print(num[i] +" ");

        }

    }*/
 /* public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String n = in.nextLine();
        String []a = null;
        a = n.split(" ");
        int k = 0;
        int []num = new int[a.length];
        for (int i = 0; i < a.length ; i++) {
            num[i] = Integer.parseInt(a[i]);
            k = num[a.length-1];
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < num.length-1; i++) {
            priorityQueue.offer(num[i]);
        }
      for (int j = 0; j < k  ; j++) {
          System.out.print(priorityQueue.poll() + " ");
      }
    }*/



//}
