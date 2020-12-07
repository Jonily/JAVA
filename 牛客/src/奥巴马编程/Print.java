package 奥巴马编程;

import java.util.Scanner;


/*public class Print {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] a = new String[2];
        String b = in.nextLine();
        a = b.split(" ");

        int n = Integer.valueOf(a[0]);
        for (int i = 0; i < n-1  ; i++) {
            if(i == 0 || i == n - 2){
                for (int j = 0; j < n ; j++) {
                    System.out.print(a[1]);
                }
                System.out.print("\n");
            }else {
                if(i % 2 == 0 && i < n-1){
                    for (int j = 0; j < n  ; j++) {
                        if(j == 0 || j == n - 1){
                            System.out.print(a[1]);
                        }else {
                            System.out.print(" ");
                        }
                    }
                    System.out.print("\n");
                }

            }
        }

    }
}*/

import java.util.Scanner;

public class Print {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int b = in.nextInt();
        String a = in.next();
        String c = "";
        for(int i =0;i<b;i++){
            c+=a;
        }
        StringBuffer sb = new StringBuffer(c);
        String d ="";
        for (int k = 1; k < b-1 ; k++) {
            d = (sb.replace(k,k+1," ")).toString();
        }
        for (int j = 0; j < b-1; j++) {
            if(j==0 || j==b-2){
                System.out.println(c);
            }else  if(j % 2!=0){
                continue;
            }else if(j%2 == 0 ) {
                System.out.println(d);
            }

        }

    }
}