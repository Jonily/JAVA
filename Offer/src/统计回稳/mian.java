package 统计回稳;

import java.util.Scanner;

public class mian {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()){
            String s1 = in.nextLine();
            String s2 = in.nextLine();

            System.out.println(Count(s1,s2));
        }

    }

    public static int Count(String s1,String s2){
        int count = 0;
        for(int i =0;i<=s1.length();i++){
            StringBuffer sb = new StringBuffer(s1);
            sb.insert(i,s2);
            StringBuffer sb2 = new StringBuffer(sb);
            sb.reverse();


            if((sb2.toString()).equals(sb.toString())){
                count++;
            }
        }
        return count;
    }
}
