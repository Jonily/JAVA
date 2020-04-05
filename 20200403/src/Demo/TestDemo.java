package Demo;

/**
 * @Description:
 * @Author HuangZhuoLin
 * @Date 2020/4/4 0:26
 */
 class Shape1{
    public void draw(){

    }
}
class Cycle extends Shape1{
    @Override
    public void draw() {
        System.out.println("这是一个⚪！");
    }
}
class Rect extends Shape1{

    @Override
    public void draw() {
        System.out.println("这是一个矩形！");
    }
}
class Flower extends Shape1{
    @Override
    public void draw() {
        System.out.println("这是一朵花！");
    }
}
public class TestDemo {
    public static void drawMap(Shape1 shape){
        shape.draw();
    }
    public static void main(String[] args) {
            // 我们创建了一个 Shape 对象的数组.发生向上转型
            Shape1[] shapes = {new Cycle(), new Rect(),  new Flower()};
            for (Shape1 shape : shapes) {
                shape.draw();
            }
       /* Rect rect = new Rect();
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
        }*/
    }
}


