package 进制转换;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map<String,Integer> map = new HashMap<>();
        for (int i = 0; i <6 ; i++) {
            map.put(String.valueOf((char)('A'+i)),10+i);
        }
        while (in.hasNext()){
            String s = in.nextLine();
            StringBuffer sb = new StringBuffer(s);
            sb = sb.reverse();
            int num = 0;
            for (int j = 0; j < sb.length()-2 ; j++) {
                if(sb.charAt(j)>='A'&&sb.charAt(j)<='F'){
                    num+=map.get(String.valueOf(sb.charAt(j)))*((int)(Math.pow(16,j)));
                    continue;
                }
                num+=(Integer.valueOf(String.valueOf(sb.charAt(j))))*((int)(Math.pow(16,j)));
            }
            System.out.println(num);
        }
    }
}
