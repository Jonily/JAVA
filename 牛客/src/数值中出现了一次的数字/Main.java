package 数值中出现了一次的数字;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNext()){
            int n = in.nextInt();
            int[]num = new int[n];
            int[]num1 = new int[2];
            Map<Integer,Integer> map = new HashMap<>();
            for (int i = 0; i < n ; i++) {
                num[i] = in.nextInt();
            }
            for (int j = 0; j < n ; j++) {
                if(map.containsKey(num[j])){
                    map.put(num[j],map.get(num[j])+1);
                }else {
                    map.put(num[j],1);
                }
            }
            int k =0;
            for (Integer key:map.keySet()) {
                if(map.get(key)%2!=0){
                    num1[k] = key;
                    k++;
                }

            }
            Arrays.sort(num1);
            String a ="";
            a =num1[0]+" "+num1[1];
            System.out.println(a);

        }
    }
}
