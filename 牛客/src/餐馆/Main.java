package 餐馆;


import java.util.*;

public class Main {
    static class Con{
        private int num ;
        private int mon;

        public Con(int num, int mon) {
            this.num = num;
            this.mon = mon;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            int m = in.nextInt();
            int[] desk = new int[n];
            int count = 0;
            for (int j = 0; j <desk.length ; j++) {
                desk[j] = in.nextInt();
            }
            List<Con> list = new ArrayList<>();
            for (int i = 0; i <m ; i++) {
                Con con = new Con(in.nextInt(),in.nextInt());
                list.add(con);
            }
            for (int k = 0; k <desk.length ; k++) {
                int[] mon = new int[m];
                for (int a= 0;a < list.size();a++) {
                    int p =0;
                    if(desk[k]>= list.get(a).num){
                        mon[p] = list.get(a).mon;
                        p++;
                        list.remove(a);
                    }
                }
                for (int i = 0; i <mon.length ; i++) {
                    count+=mon[i];
                }
            }
            System.out.println(count);
        }

    }
}
