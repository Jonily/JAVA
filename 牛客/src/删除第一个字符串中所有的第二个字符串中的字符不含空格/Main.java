package 删除第一个字符串中所有的第二个字符串中的字符不含空格;
import java.util.*;
public class Main{
    public static void main (String[] args){
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        String b = in.nextLine();
        System.out.println(printString(a,b));
    }
    public static String printString(String a, String b){
        char c = 'a';
        String e = a;
        for(int i = 0; i < a.length(); i++){
               c = a.charAt(i);
            for (int j = 0; j < b.length() ; j++) {
                if(c == b.charAt(j)){
                    e = deleteChar(e,c);
                    continue;
                }
            }
        }
        return e;
    }
    public static String deleteChar(String e,char c){
        String d = "";
        for (int i = 0; i < e.length() ; i++) {
            if(e.charAt(i) != c){
                d += e.charAt(i);
            }
        }
        return d;
    }
}

 class Main1{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            char[] ch = sc.nextLine().toCharArray();
            String str = sc.nextLine();
            for(int i=0;i<ch.length;i++){
                if(!str.contains(String.valueOf(ch[i]))){
                    System.out.print(ch[i]);
                }
            }
        }
    }
}
