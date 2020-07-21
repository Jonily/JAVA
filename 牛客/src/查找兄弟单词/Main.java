package 查找兄弟单词;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            List<String> list = new ArrayList<>();
            List<String> list1 = new ArrayList<>();
            int n = in.nextInt();
            for (int i = 0; i <n ; i++) {
                list.add(in.next());
            }
            String s = in.next();
            int index = in.nextInt();
            int count =0;
            for (String str: list) {
                if(!str.equals(s)){
                    if(just(str,s)){
                        count++;
                        list1.add(str);
                    }
                }
            }
            Collections.sort(list1);
                System.out.println(count);
                if(index<=list1.size()){
                    System.out.println(list1.get(index-1));

                }
        }
    }

    private static boolean just(String str, String s) {
        char[] a = str.toCharArray();
        char[] b = s.toCharArray();
        int count =0;
        if(a.length==b.length){
            for (int i = 0; i <a.length ; i++) {
                for (int j = 0; j <b.length ; j++) {
                    if(a[i]==b[j]){
                        b[j]='\0';
                        count++;
                        break;
                    }else {
                        continue;
                    }
                }
            }
            if (count == b.length) {
                return true;
            }else {
                return false;
            }
        }else {
            return false;
        }

    }
}
