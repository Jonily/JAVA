package Demo;

/**
 * @Description:
 * @Author HuangZhuoLin
 * @Date 2020/4/4 0:26
 */
class Shape{
    public void draw(){

    }
}
class Cycle extends Shape{
    @Override
    public void draw() {
        System.out.println("这是一个⚪！");
    }
}
class Rect extends Shape{

    @Override
    public void draw() {
        System.out.println("这是一个矩形！");
    }
}
class Flower extends Shape{
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
        Rect rect = new Rect();
        Cycle cycle = new Cycle();
        Flower flower = new Flower();
        String[] shapes = {"cycle", "rect", "flower"};
        for (String shape : shapes) {
            if (shape.equals("cycle")) {
                cycle.draw();
            } else if (shape.equals("rect")) {
                rect.draw();
            } else if (shape.equals("flower")) {
                flower.draw();         }
        }
    }
}


