package Demo3;

/**
 * @Description:
 * @Author HuangZhuoLin
 * @Date 2020/4/5 10:13
 */
class Animal {
    protected String name;
    public Animal(String name) {
    this.name = name;
   }
}
interface IFlying {
    void fly();
}
interface IRunning {
    void run();
}
interface ISwimming {
    void swim();
}
//一个类可以继承一个类并且实现多个接口
class Cat extends Animal implements IRunning {
    public Cat(String name) {
        super(name);
    }
    @Override
    public void run() {
        System.out.println(this.name + "正在用四条腿跑");
    }
}
class Frog extends Animal implements IRunning, ISwimming {
    public Frog(String name) {
        super(name);
    }
    @Override
    public void run() {
        System.out.println(this.name + "正在往前跳");
    }
    @Override
    public void swim() {
        System.out.println(this.name + "正在蹬腿游泳");
    }
}
public class Test {
    public static void walk(IRunning iRunning){
        iRunning.run();
    }

    public static void main(String[] args) {
        Cat cat = new Cat("hh");
        walk(cat);
    }
}
