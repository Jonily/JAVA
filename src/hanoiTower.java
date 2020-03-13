import java.util.Scanner;
public class hanoiTower {
    public static void main(String[] args) {
        System.out.println("输入要移动盘子的个数：");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char A = 'A';
        char B = 'B';
        char C = 'C';
        System.out.println("需要的步骤为：");
        hanoi(n,A,B,C);
    }
    public static void move(char A , char C){
           System.out.println(A+"->"+C);
    }
    public static void hanoi(int n , char A , char B , char C){
        if (n==1){
            move(A , C);
        }else{
            hanoi(n-1 , A , C , B);
            move(A , C);
            hanoi(n-1 , B , A , C);
        }
    }
}
