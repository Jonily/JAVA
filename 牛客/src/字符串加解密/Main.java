package 字符串加解密;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map<String,String> map = new LinkedHashMap<>();
        Map<String,String> map1 = new LinkedHashMap<>();
        while (in.hasNext()){
            String a = in.next();
            String b = in.next();
            char s1 = 'a';
                while (s1!='z'){
                    map.put(String.valueOf(s1),String.valueOf((char) (s1+1)).toUpperCase());
                    s1+=1;
                }
            map.put("z","A");
            char s2 = 'A';
            while (s2!='Z'){
                map.put(String.valueOf(s2),String.valueOf((char) (s2+1)).toLowerCase());
                s2+=1;
            }
            map.put("Z","a");
            char s3 = '0';
            while (s3!='9'){
                map.put(String.valueOf(s3),String.valueOf((char) (s3+1)));
                s3+=1;
            }
            map.put("9","0");

            map1.put("a","Z");
            char s4 = 'b';
            while (s4!='z'){
                map1.put(String.valueOf(s4),String.valueOf((char) (s4-1)).toUpperCase());
                s4+=1;
            }
            map1.put("z","Y");


            map1.put("A","z");
            char s5 = 'B';
            while (s5 !='Z'){
                map1.put(String.valueOf(s5),String.valueOf((char) (s5 -1)).toLowerCase());
                s5 +=1;
            }
            map1.put("Z","y");

            map1.put("0","9");
            char s6 = '1';
            while (s6 !='9'){
                map1.put(String.valueOf(s6),String.valueOf((char) (s6 -1)));
                s6 +=1;
            }
            map1.put("9","8");

            System.out.println(Get(a,map));
            System.out.println(Get(b,map1));
        }
    }

    private static String Get(String a,Map map) {
        String c = "";
        for (int i = 0; i < a.length() ; i++) {
                c+=map.get(String.valueOf(a.charAt(i)));
        }
        return c;
    }
}
