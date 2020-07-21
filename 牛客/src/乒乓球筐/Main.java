package 乒乓球筐;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            char[] A = in.next().toCharArray();
            char[] B = in.next().toCharArray();
            if(just(A,B)){
                System.out.println("Yes");
            }else {
                System.out.println("No");
            }
        }
    }

    private static boolean just(char[] a, char[] b) {
       int count=0;
       int flag =b.length;
        for (int i = 0; i <a.length ; i++) {
            for (int j = 0; j < b.length; j++) {
                if(b[j]==a[i]){
                    count++;
                    b[j]='\0';
                    break;
                }
            }
        }
        if(count==flag){
            return true;
        }else {
            return false;
        }
    }
}
