import java.util.Scanner;
public class frogSeat {
    public static void main(String[] args) {
        System.out.println("输入青蛙要跳的台阶数：");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        jump(n);
    }
        public  static void jump(int n) {
        int []funArrays = new int[999];
        funArrays[0] = 1;
        funArrays[1] = 2;
        int j = 0 ;
        if (n == 1) {
            System.out.println("方法有"+ funArrays[0]+"种！");
        }
        if (n == 2) {
            System.out.println("方法有"+ funArrays[1]+"种！");
        }else {
            for (j = 2; j <= n-1; j++) {
                funArrays[j]=funArrays[j-1]+funArrays[j-2];

            }
            System.out.println("方法有"+ funArrays[n-1]+"种！");
        }
     }
}






    /*
        public static void main(String[] args) {
            System.out.println("输入青蛙要跳的台阶数：");
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int sum = jump(n);
            System.out.println("青蛙有"+sum+"种跳法！");
        }
        public  static int jump(int n){
            int i = 1 ;
            int j = 2 ;
            int k = 0 ;
            if (n==1){
                return n ;
            }else if(n==2) {
                return n ;
            } else{
                for (int a = 3 ; a<=n ; a++){
                    k = i+j ;
                    i=j;
                    j=k;
                }
                return k ;
            }
        }
    }*/




    /*
    public static void main(String[] args) {
        System.out.println("输入青蛙要跳的台阶数：");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = jump(n);
        System.out.println("青蛙有"+sum+"种跳法！");
    }
    public static int jump(int n){
        int sum = 0 ;
        if(n==1){
            return 1 ;
        }else if(n==2){
            return 2 ;
        }else{
            sum = jump(n-1)+jump(n-2);
        }
        return sum ;
    }
}
*/
