package 坏键;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()){
            String s = in.nextLine();
            String s1 = in.nextLine();
            Set<String> set = new LinkedHashSet<>();
                for (int j = 0; j < s.length() ; j++) {
                    if(!s1.contains(String.valueOf(s.charAt(j)))){
                        if(s.charAt(j)>='a' && s.charAt(j)<='z'){
                           char a =  s.charAt(j);
                           a = (char) (s.charAt(j) - 32);
                           set.add(String.valueOf(a));
                           continue;
                        }
                        set.add(String.valueOf(s.charAt(j)));
                    }
                }
            String str = "";

            for (String key:set) {
                str+=key;
            }
            System.out.println(str);

        }
    }
}
