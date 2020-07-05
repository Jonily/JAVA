package 说反话;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()){
            String[] sb = in.nextLine().split(" ");
            String s = "";
            for (int i = sb.length - 1; i >0 ; i--) {
                s+=sb[i]+" ";
            }
            System.out.println(s+sb[0]);
        }
    }
}
