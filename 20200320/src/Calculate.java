/**
 * @Description: 设计一个抽象类图形类，在该类中包含有至少两个抽象方法求周长和求面积，分别定义圆形类、长方形类、正方形类来继承图形类，并实现上述两个方法。
 * @Author HuangZhuoLin
 * @Date 2020/3/20 21:07
 */
import java.util.Scanner;
import static java.lang.Math.PI;
abstract class Shape {
    public abstract double shapeC();
    public abstract double shapeS();
}
class Circle extends Shape {
    private double r;
    public Circle (double r){
        this.r = r;
    }
    public double getR() {
        return r;
    }
    public void setR(double r) {
        this.r = r;
    }
    public double shapeC(){
        return PI*2*r;
    }
    public double shapeS(){
        return PI*r*r;
    }
}
class Square extends Shape {
    private double f;
    public Square (double f){
        this.f = f;
    }
    public double getF() {
        return f;
    }
    public void setF(double f) {
        this.f = f;
    }
    public double shapeC(){
        return 4*f;
    }
    public double shapeS(){
        return Math.pow(f,2);
    }
}
class Triangle extends Shape {
    private double a;
    private double b;
    private double c;
    public Triangle(double a,double b,double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public double getA() {
        return a;
    }
    public void setA(double a) {
        this.a = a;
    }
    public double getB() {
        return b;
    }
    public void setB(double b) {
        this.b = b;
    }
    public double getC() {
        return c;
    }
    public void setC(double c) {
        this.c = c;
    }
    public double shapeC(){
        return a+b+c;
    }
    public double shapeS(){
        double s = (a+b+c)/2.0;
        return Math.sqrt(s*(s-a)*(s-b)*(s-c));
    }
}
class Rectangle extends Shape {
    private double l;
    private double w;
    public Rectangle(double l, double w) {
        this.l = l;
        this.w = w;
    }

    public double getL() {
        return l;
    }

    public void setL(double l) {
        this.l = l;
    }

    public double getW() {
        return w;
    }

    public void setW(double w) {
        this.w = w;
    }
    public double shapeC(){
        return (l+w)*2;
    }
    public double shapeS(){
        return l*w;
    }
}
public class Calculate{
    public static void main(String[]args){
        boolean flag = true;
        while(flag){
            System.out.println("=============================");
            System.out.println("======请选择需要计算的图形======");
            System.out.println("         (1) 圆形");
            System.out.println("        （2）正方形");
            System.out.println("        （3）长方形");
            System.out.println("        （4）三角形");
            System.out.println("        （5）退  出");
            Scanner num = new Scanner(System.in);
            int n = num.nextInt();
            switch(n){
                case 1:{
                    System.out.println("请输入圆的半径：");
                    Scanner sc = new Scanner(System.in);
                    double a = sc.nextDouble();
                    Circle circle = new Circle(a);
                    System.out.println("圆的半径为："+circle.getR());
                    System.out.println("圆的周长为："+circle.shapeC());
                    System.out.println("圆的面积为："+circle.shapeS());
                }
                break;
                case 2:{
                    System.out.println("请输入正方形的边长：");
                    Scanner s = new Scanner(System.in);
                    double f = s.nextDouble();
                    Square square = new Square(f);
                    System.out.println("正方形的边长为："+square.getF());
                    System.out.println("正方形的周长为："+square.shapeC());
                    System.out.println("正方形的面积为："+square.shapeS());
                }
                break;
                case 3:{
                    System.out.println("请输入长方形的边长：");
                    Scanner s = new Scanner(System.in);
                    System.out.println("输入长方形的长：");
                    double l = s.nextDouble();
                    System.out.println("输入长方形的宽：");
                    double w = s.nextDouble();
                    Rectangle rectangle = new Rectangle(l,w);
                    System.out.println("长方形的长为："+rectangle.getL()+"长方形的宽为："+rectangle.getW());
                    System.out.println("长方形的周长为："+rectangle.shapeC());
                    System.out.println("长方形的面积为："+rectangle.shapeS());
                }
                break;
                case 4:{
                    System.out.println("请输入三角形的三边：");
                    Scanner s = new Scanner(System.in);
                    double a = s.nextDouble();
                    double b = s.nextDouble();
                    double c = s.nextDouble();
                    if ((a+b)>c && (a+c)>b && (b+c)>a){
                        Triangle triangle = new Triangle(a,b,c);
                        System.out.println("三角形的三边："+ triangle.getA() + ", "+triangle.getB() + ", "+triangle.getC());
                        System.out.println("三角形的周长："+triangle.shapeC());
                        System.out.println("三角形的面积："+triangle.shapeS());
                    }else{
                        System.out.println("输入的三角形不成立,请重新输入！！！");
                    }
                }
                break;
                case 5:{
                    flag = false;
                }
                break;
            }
        }
    }
}
