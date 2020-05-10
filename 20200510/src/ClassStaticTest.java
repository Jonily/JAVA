public class ClassStaticTest {
    static void doStuff(Shape s){
        s.draw();
    }
    public static void main(String[] args){
        Circle c = new Circle();
        Triangle t = new Triangle();
        doStuff(c);
        doStuff(t);
        c.draw();
        t.draw();
    }
}

        class Shape{
            static void draw(){
                System.out.println("Shape Drawing");
            }
        }
        class Circle extends Shape {
            static void draw(){
                System.out.println("Circle drawing");
            }
        }
        class Triangle extends Shape {
            static void draw(){
                System.out.println("Triangle drawing");
            }
        }
