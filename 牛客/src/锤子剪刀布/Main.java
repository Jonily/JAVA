package 锤子剪刀布;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map<String,Integer> mapA = new HashMap<>();
        Map<String,Integer> mapB = new HashMap<>();

        while (in.hasNext()){
            int n = in.nextInt();
                String[] A = new String[n];
                String[] B = new String[n];
            for (int i =0; i < n;i++) {
                A[i] = in.next();
                B[i] = in.next();
            }
            int v =0;
            int tie = 0;
            int fail = 0;

            for (int i = 0; i < n ; i++) {
                int flag = match(A[i],B[i]);
                if(flag == 0){
                    tie++;
                }
                if(flag == 1){
                    v++;
                    if(mapA.containsKey(A[i])){
                        mapA.put(A[i],mapA.get(A[i])+1);
                    }else {
                        mapA.put(A[i],1);
                    }
                }
                if(flag == -1){
                    fail++;
                    if(mapB.containsKey(B[i])){
                        mapB.put(B[i],mapB.get(B[i])+1);
                    }else {
                        mapB.put(B[i],1);
                    }
                }

            }
            System.out.println(v+" "+tie+" "+fail);
            System.out.println(fail+" "+tie+" "+v);
            int max = 0;
            for (Map.Entry<String, Integer> m : mapA.entrySet()) {
                if (m.getValue() > max) {
                    max = m.getValue();
                }
            }
            if (max == 0) {
                System.out.print("B");
            } else {
                for (Map.Entry<String, Integer> m : mapA.entrySet()) {
                    if (m.getValue() == max) {
                        System.out.print(m.getKey());
                        break;
                    }
                }
            }
            max = 0;
            System.out.print(" ");
            for (Map.Entry<String, Integer> m : mapB.entrySet()) {
                if (m.getValue() > max) {
                    max = m.getValue();
                }
            }
            if (max == 0) {
                System.out.print("B");
            } else {
                for (Map.Entry<String, Integer> m : mapB.entrySet()) {
                    if (m.getValue() == max) {
                        System.out.print(m.getKey());
                        break;
                    }
                }
            }

        }
    }

    private static int match(String s, String s1) {
        if(s.equals(s1)){
            return 0;
        }else if((s.equals("C") && ("J".equals(s1))) || (("J".equals(s)) && ("B".equals(s1))) || (("B".equals(s)) && ("C".equals(s1)))){
            return 1;
        }else {
            return -1;
        }
    }
}
