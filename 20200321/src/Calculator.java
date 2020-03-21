

/**
 * @Description:
 * @Author HuangZhuoLin
 * @Date 2020/3/21 21:09
 */
import java.util.Scanner;
public class Calculator {
    private double num1;
    private double num2;
    public Calculator(double num1,double num2){
     this.num1 = num1;
     this.num2 = num2;
    }
    public double getNum1() {
        return num1;
    }

    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public double getNum2() {
        return num2;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }
    public double add(){
        return num1+num2;
}
    public double sub(){
        return num1-num2;
    }
    public double mul(){
        return num1*num2;
    }
    public double div(){
        return num1/num2;
    }
}
 class test{
public static void main(String[]args){
    System.out.println("请输入两个数字：");
    Scanner sc = new Scanner(System.in);
    double a = sc.nextDouble();
    double b = sc.nextDouble();
    Calculator calculator = new Calculator(a,b);
    System.out.println("计算加法：");
     System.out.println(calculator.add());
    System.out.println("计算减法：");
    System.out.println(calculator.sub());
    System.out.println("计算乘法：");
    System.out.println(calculator.mul());
    System.out.println("计算除法：");
    System.out.println(calculator.div());
     }
}
