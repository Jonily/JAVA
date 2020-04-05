package Demo2;

/**
 * @Description:
 * @Author HuangZhuoLin
 * @Date 2020/4/5 9:41
 */

interface Shape{
    public abstract void draw();
}
class Cycle implements Shape {
    @Override
    public void draw() {
        System.out.println("这是一个⚪！");
    }
}
class Rect implements Shape {
    @Override
    public void draw() {
        System.out.println("这是一个矩形！");
    }
}
class Flower implements Shape {
    @Override
    public void draw() {
        System.out.println("这是一朵花！");
    }
}
public class TestDemo {
    public static void drawMap(Shape shape){
        shape.draw();
    }
    public static void main(String[] args) {
        Shape shape = new Cycle();
        drawMap(shape);
    }
}
