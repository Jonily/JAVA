import java.util.Scanner;

public class Test1{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        Printf(num);


    }
    public static void Printf(int num){
        for(int i = 0; i<= num; i++){
            int count = 0;
            int tmp = i;
            while(tmp != 0){
                count++;
                tmp=tmp/10;
            }
            tmp = i;
            long sum = 0;
            while(tmp != 0){
                sum += Math.pow(tmp%10,count);
                tmp/=10;
            }
            if(sum == i){
                System.out.print(i+" ");
            }


        }


    }
}
