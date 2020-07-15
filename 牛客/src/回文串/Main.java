package 回文串;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Set<String> set = new HashSet<>();
        while (in.hasNext()){
            String s = in.next();
            for (int i = 0; i <s.length() ; i++) {
                set.add(String.valueOf(s.charAt(i)));
            }
            List<String> list = new ArrayList<>(set);
            if(just(list,s)){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }
    }

    private static boolean just(List<String> list, String s) {
        for (int j = 0; j < list.size(); j++) {
            for (int k = 0; k <= s.length() ; k++) {
                StringBuffer sb = new StringBuffer(s);
                StringBuffer str = sb.insert(k,list.get(j));
                StringBuffer str1 = new StringBuffer(str).reverse();
                if(str.toString().equals(str1.toString())){
                    return true;
                }
            }
        }
        return false;
    }
}
