package 地下迷宫;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            int m = in.nextInt();
            int[][] num= new int[n][m];
            int p = in.nextInt();
            for (int i = 0; i < n ; i++) {
                for (int j = 0; j < m; j++) {
                    num[i][j] = in.nextInt();
                }
            }
            run(num);
        }
    }
}
