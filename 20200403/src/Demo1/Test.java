package Demo1;

/**
 * @Description:
 * @Author HuangZhuoLin
 * @Date 2020/4/5 8:56
 */
abstract class Shape{
    public abstract void draw();
}
class Cycle extends Shape {
    @Override
    public void draw() {
        System.out.println("这是一个⚪！");
    }
}
class Rect extends Shape {
    @Override
    public void draw() {
        System.out.println("这是一个矩形！");
    }
}
class Flower extends Shape {
    @Override
    public void draw() {
        System.out.println("这是一朵花！");
    }
}
public class Test {
    public static void drawMap(Shape shape){
        shape.draw();
    }
    public static void main(String[] args) {


    }

}
