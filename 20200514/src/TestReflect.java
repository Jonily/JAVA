
class Cat{
    public Cat(String name) {
        this.name = name;
    }

    private String name;
    public void eat(String food){
        System.out.println(name + "正在吃" + food);
    }
}


public class TestReflect {
    public static void main(String[] args) throws ClassNotFoundException {
        //获取类对象
        //第一种获取方式是最灵活的，写代码的时候根本不需要知道类名，在实际运行时再获取类名
        //1、直接通过全限定类名获取
        Class catClass = Class.forName("Cat");
        //2、通过类的实例获取
        Cat cat = new Cat("咪咪");
        Class catClass2 = cat.getClass();
        //3、通过类来直接获取
        Class catClass3  = Cat.class;

        System.out.println(catClass == catClass2);
        System.out.println(catClass == catClass3);

    }

}
