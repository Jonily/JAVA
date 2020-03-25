/**
 * @Description:  动物抽象类
 * @Author HuangZhuoLin
 * @Date 2020/3/24 16:34
 */

 abstract class Animal {
    public Animal(String name, int age) {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
    //动物共有的两个行为用两个抽象方法表示
    //一个类中如果有一个抽象方法，必须定义为抽象类
    public abstract void eat();
    public abstract void sleep();

}
  class Dog extends Animal{
    public Dog(String name,int age){
        super(name,age);
    }
        public void eat(){
            System.out.println("吃饭");

        }
        public  void sleep(){
            System.out.println("睡觉");
        }

    }
class Test{
    public static void main(String[] args) {
        Animal animal = new Dog("gou", 2);
        animal.eat();
        animal.sleep();
    }
}