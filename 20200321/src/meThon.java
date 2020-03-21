/**
 * @Description:
 * @Author HuangZhuoLin
 * @Date 2020/3/21 23:55
 */

import java.util.Scanner;
public class meThon {
    public static void main (String[]args){
        System.out.println("请输入数字：");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        fun(n);
    }
    public static void fun (int n){
        int i = 0 ;
        System.out.println("奇数位：");
        for (i = 31 ; i>=1 ; i-=2 ){
            System.out.print( ((n>>>i) & 1) + " ");
        }
        System.out.println(" ");
        System.out.println("偶数位：");
        for (i = 30 ; i>=0 ; i-=2 ){
            System.out.print( ((n>>>i) & 1) +" ");
        }
    }
}




/*
	public static void main(String[]args){
		System.out.println("请输入密码：（有三次输入机会!）");
		int count = 3 ;
		while (count != 0) {
		Scanner sc = new Scanner(System.in);
		String password = sc.next();
			if(password.equals("7758521")){
		System.out.println("密码正确，登录成功！");
		    break;
			}else{
				count--;
		System.out.println("密码错误，重新输入！");
		System.out.println("你还有"+count+"次机会！");
     	}
     }
   }
}*/



/*
	public static void main (String[]args){
		System.out.println("请输入数字");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
	    System.out.println("数字的每一位是：");
		fan(n);
	}
	public static void fan(int n){
		if (n>9){
			fan(n/10);
		}
			System.out.print(" "+ n%10+" ");

		}
}
*/


	/*public static void main (String[] args){
	           System.out.println("请输入数字");
		       Scanner sc = new Scanner(System.in);
		       int k = sc.nextInt();
               fan(k);
          }
    public static void fan (int k) {
			System.out.println(" \n输出乘法口诀表：");
			int t = 1 ;
			int j = 1 ;
			int a = 0 ;
			for (t = 1 ; t<= k; t++){
			System.out.print( "\n"  );
			for (j = 1 ; j<=t ; j++){
			System.out.print( " "+ j+" "+"*"+" "+ t+" ="+(j*t)+" ");
		    }
        }
     }
 }*/

