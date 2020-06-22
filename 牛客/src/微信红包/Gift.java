package 微信红包;

import java.util.*;

public class Gift {
    public int getValue(int[] gifts, int n) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(gifts[i]);
        }
        for (Integer s:set) {
            int count = 0;
            for (int j = 0; j < n ; j++) {
                if(s == gifts[j]){
                    count++;
                }
            }
            if(count > n/2){
                return s;
            }
        }
        return 0;
    }


    }
