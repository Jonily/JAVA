
class Cat{
    private String name;

    public void eat(String food){
        System.out.println(name + "正在吃" + food);
    }
    public Cat(String name){
        this.name = name;
    }
}
public class TestReflect {
    public static void main(String[] args) throws ClassNotFoundException {
        //获取类对象Cat，Cat类的说明书
        //1、直接通过全限定类名获取
        Class catClass = Class.forName("Cat");

        //2、通过类的实例化获取
        Cat cat = new Cat("mimi");
        Class catClass2 = cat.getClass();

        //3、通过类来直接获取
        Class catClass3 = Cat.class;

        System.out.println(catClass == catClass2);
        System.out.println(catClass == catClass3);
        System.out.println(catClass2 == catClass3);

    }

}
