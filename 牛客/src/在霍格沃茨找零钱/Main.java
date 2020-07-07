package 在霍格沃茨找零钱;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String[] s1 = in.next().split("\\.");
            String[] s2 = in.next().split("\\.");
            int[] need = new int[3];
            int[] pay = new int[3];
            int[] get = new int[3];
            for (int i = 0; i < 3 ; i++) {
                need[i] = Integer.parseInt(s1[i]);
                pay[i] =  Integer.parseInt(s2[i]);
            }
            int getMon =((pay[0]*17+pay[1])*29 + pay[2])- ((need[0]*17+need[1])*29+need[2]);
            get[2] = Math.abs((getMon) % 29);
            get[1] = Math.abs(((getMon - get[2])/29)%17);
            get[0] = ((getMon - get[2])/29)/17;
            String mon = get[0]+"."+get[1]+"."+get[2];
            System.out.println(mon);
        }
    }
}
