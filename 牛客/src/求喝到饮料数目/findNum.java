package 求喝到饮料数目;

import java.util.Scanner;

public class findNum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int a = in.nextInt();
            if( a== 0){
                break;
            }
            int b = findNum(a);
            System.out.println(b);
        }
    }
    public static int findNum(int num){
        if(num == 3 || num == 2){
            return 1;
        }
        int count = 0;
        count = num/3;
        num = count + num % 3;
        count += findNum(num);
        return count;
    }
}


 class Main1 {
    public static int drink(int n) {
        int total = 0;//饮料总数
//当大于两个空瓶的时候才可以换饮料
        while(n > 2) {
//n/3-->能够换来的饮料
            total = total+n/3;
//新的空瓶子个数--》n%3可能会不能整除
            n = n/3 + n%3;
        }
//如果n==2，说明有两个空瓶可以喝商家借一瓶饮料
        if(n == 2) {
            total = total + 1;
        }
        return total;
    }
    public static void main(String[] args){
//创建键盘录入对象
        Scanner sc=new Scanner(System.in);
        int n;
        while(sc.hasNext())
        {
            n=sc.nextInt();
            System.out.println(drink(n));
        }
    }
}