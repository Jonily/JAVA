package 裴波拉契数列;

public class Solution {
/*    public int Fibonacci(int n) {
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }else{
            return (Fibonacci(n-1)+Fibonacci(n-2));
        }

    }*/
    public int Fibonacci(int n) {
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        int a = 0;
        int b = 1;
        int c = 0;
        for (int i = 2; i <= n ; i++) {
            c = a+b;
            a = b;
            b = c;

        }
        return c;

    }
}