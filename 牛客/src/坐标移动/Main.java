package 坐标移动;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String[]s = in.next().split(";");
            int x = 0;
            int y = 0;
            for (int i = 0; i < s.length; i++) {
                if(s[i].length()<=3 && s[i].length()>=2 ){
                   /* if(!Character.isDigit((s[i].charAt(1)))){
                            continue;
                    }
                    if(s[i].length() == 3 && !Character.isDigit((s[i].charAt(2)))){
                        continue;
                    }*/
                    if(s[i].charAt(0)=='A'&& s[i].substring(1).matches("[0-9]+")){
                        int step = Integer.parseInt(s[i].substring(1));
                        if(step >=0 && step<=99)
                        x-=step;
                    }
                    if(s[i].charAt(0)=='D'&& s[i].substring(1).matches("[0-9]+")){
                        int step = Integer.parseInt(s[i].substring(1));
                        if(step >=0 && step<=99)
                            x+=step;
                    }
                    if(s[i].charAt(0)=='S'&& s[i].substring(1).matches("[0-9]+")){
                        int step = Integer.parseInt(s[i].substring(1));
                        if(step >=0 && step<=99)
                            y-=step;
                    }
                    if(s[i].charAt(0)=='W'&& s[i].substring(1).matches("[0-9]+")){
                        int step = Integer.parseInt(s[i].substring(1));
                        if(step >=0 && step<=99)
                            y+=step;
                    }
                }
            }
            System.out.println(x+","+y);
        }
    }
}
