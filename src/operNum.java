import java.util.Scanner;
public class operNum {/*
    public static void main(String[] args) {
        System.out.println("输入数字的个数为：");
        Scanner sc = new Scanner (System.in);
        int k = sc.nextInt();
        if(k==2){
            System.out.println("输入数字：");
            int a = sc.nextInt();
            int b = sc.nextInt();
            int sum1 = add( a , b );
            System.out.println("两数之和为："+sum1);
        }else if (k==3){
            System.out.println("输入数字：");
            double e = sc.nextDouble();
            double f = sc.nextDouble();
            double g = sc.nextDouble();
            double sum2 = add( e , f , g );
            System.out.println("两数之和为："+sum2);
        }
    }
    public static int add(int a, int b){
        int i = a + b ;
        return i ;
    }
    public static double add(double e, double f, double g){
        double i = e + f + g;
        return i ;
    }
}*/


    public static void main(String[] args) {
        System.out.println("输入数字的个数为：");
        Scanner sc = new Scanner (System.in);
        int k = sc.nextInt();
        if(k==2){
            System.out.println("输入数字：");
            int a = sc.nextInt();
            int b = sc.nextInt();
            int num1 = max( a , b );
            System.out.println("最大值为："+num1);
            double c = sc.nextDouble();
            double d = sc.nextDouble();
            double num2 = max( c , d );
            System.out.println("最大值为："+num2);
        }else if (k==3){
            System.out.println("输入数字：");
            double e = sc.nextDouble();
            double f = sc.nextDouble();
            int g = sc.nextInt();
            double num3 = max( e , f , g );
            System.out.println("最大值为："+num3);
        }

    }
    public static int max(int a, int b){
        int i = a>b?a:b;
        return i ;
    }
    public static double max(double a, double b){
        double i = a>b?a:b;
        return i ;
    }
    public static double max(double e, double f, int g){
        double i = max(e,f)>g?max(e,f):g;
        return i ;
    }
}

