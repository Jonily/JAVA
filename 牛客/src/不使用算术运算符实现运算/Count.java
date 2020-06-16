package 不使用算术运算符实现运算;

import java.util.Scanner;

public class Count {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int A = in.nextInt();
        int B = in.nextInt();
        int C = addAB(A,B);
        System.out.println(C);
    }
    public static int addAB(int A, int B) {
        int tmp = A ^ B;
        int carry = (A&B)<<1;
        int sum = tmp + carry;
        return sum;
    }
}
