package 单词倒排;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String[] s = in.nextLine().split(" ");
            List<String> list = new ArrayList<>();
            for (String st: s) {
                list.add(st);
            }
            String s1 = "";
            for (String sb:list) {
                if(!"".equals(sb)){
                    s1+=sb+" ";
                }
            }
            list.clear();
            s=s1.split(" ");
            for (int i = s.length -1; i >= 0 ; i--) {
                for (int j = 0; j < s[i].length(); j++) {
                    if(!just(s[i].charAt(j))){
                        s[i] = " ";
                        break;
                    }
                }
                list.add(s[i]);
            }
            String str = "";
            for (String s2: list) {
                if(!" ".equals(s2)){
                    str+=s2+" ";
                }
            }
            str = str.substring(0,str.length()-1);
            System.out.println(str);
        }
    }
    private static boolean just(char charAt) {
        if(charAt>='a'&&charAt<='z'){
            return true;
        }
        if(charAt>='A'&&charAt<='Z'){
            return true;
        }
        return false;

    }
}
/*

        import java.util.Scanner;

public class Main
{

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String[] sp = sc.nextLine().split("[^a-zA-Z]+");
        StringBuilder sb = new StringBuilder();
        for (int i = sp.length - 1; i >= 0; i--)
            sb.append(sp[i] + " ");
        System.out.println(sb.toString().trim());
        sc.close();
    }

}
*/
