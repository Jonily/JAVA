package 字母统计;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map<String,Integer> map = new HashMap<>();
        char s1 = 'A';
        for (int j = 0; j < 26 ; j++) {
            map.put(String.valueOf((char)(s1+j) ),0);
        }
        while (in.hasNext()){
            String s = in.nextLine();
            for (int i = 0; i <s.length() ; i++) {
                if(s.charAt(i)>='A'&&s.charAt(i)<='Z'){
                        map.put(String.valueOf(s.charAt(i)),map.get(String.valueOf(s.charAt(i)))+1);
                }
            }
            for (Object k: map.keySet()) {
                System.out.println(k+":"+map.get(k));
            }
        }
        in.close();
    }
}
