package 小易的升级之路;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            int a = in.nextInt();
            int[] mon = new int[n];
            for (int i = 0; i < mon.length; i++) {
                mon[i] = in.nextInt();
            }
            for (int j = 0; j < mon.length ; j++) {
                if(mon[j] <= a){
                    a+=mon[j];
                }else {
                   int c =  getNum(mon[j],a);
                   a+=c;
                }
            }
            System.out.println(a);
        }
        in.close();
    }
    public static int getNum(int mon, int a){
        if(mon % a == 0){
            return a;
        }
        return getNum(a,mon % a);

    }

}
