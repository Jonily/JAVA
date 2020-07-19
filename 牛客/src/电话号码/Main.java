package 电话号码;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String symbol="ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        String number="222333444555666777788899991234567890";
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n =in.nextInt();

            List<String> list = new ArrayList<>();
            for (int i = 0; i < n ; i++) {
                String s =in.next();
                s = s.replace("-","");
                String ret ="";
                for (int j = 0; j <s.length() ; j++) {

                       ret+=number.charAt(symbol.indexOf(s.charAt(j)));

                }
                ret = ret.substring(0,3)+"-"+ret.substring(3,7);
                if(!list.contains(ret)){
                    list.add(ret);
                }

            }
            Collections.sort(list);
            for (String s: list) {
                System.out.println(s);
            }
            System.out.println();

        }
    }
}
