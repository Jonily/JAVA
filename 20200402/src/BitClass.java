/**
 * @Description: 接口
 * @Author HuangZhuoLin
 * @Date 2020/4/2 18:28
 */
/*abstract class Shape{
    public abstract void draw();

}*/
//1、接口中的数据成员必须是一个常量
  //2、  默认都是public static final
    //3、里面的成员方法默认为抽象方法
    //4、接口中不能添加有具体实现的方法
    //5、JDK1.8中接口可以有实现的方法，但是一定要被default修饰
    //6、类和接口--》需要implement 可以实现多个接口 实现多借口
    //7、解决了多继承问题
    //8、实现了该接口,一定要重写该接口中的方法
    //9、接口不能被实例化，但是可以发生向上转型
    //10、实现该接口的方法的时候一定不能省略
interface Shape{
  void draw();
}
class Cycle implements Shape {
    public void draw() {
        System.out.println("这是一个圆！");
    }

}
public class BitClass {
    public static void main(String[] args) {
        Shape shape = new Cycle();
        shape.draw();


    }

}
