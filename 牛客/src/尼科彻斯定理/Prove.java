package 尼科彻斯定理;


import java.util.Scanner;
public class Prove {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int num = in.nextInt();
            String b = GetSequeOddNum(num);
            System.out.println(b);
        }
    }
    public static String GetSequeOddNum(int m) {
        String a = "";
        int p = 0;
        for (int i = 1; i < m ; i++){
            p += i;
        }
        int count = 1;
        int n = 1;
        while (count != (p+1)){
            n = n + 2;
            count++;
        }
        for (int i = 0; i < m ; i++) {
            a += String.valueOf(n);
            if(i != m-1){
                a+="+";
            }
            n = n+2;
        }
        return a;
    }
}
