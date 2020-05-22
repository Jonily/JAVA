package 反射的使用;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class Cat {
    private String name = "mimi";

    public Cat() {

    }

    public Cat(String name) {
        this.name = name;
    }

    public void eat(String food) {
        System.out.println(name + "正在吃" + food);
    }
    public void eat(String food1, String food2) {
        System.out.println(name + "正在吃" + food1 + "和" + food2);
    }
}
public class TestReflect {

    //通过反射来获取对象的属性
    public static void teatField() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        //1、先获取类对象
        Class catClass = Class.forName("反射的使用.Cat");//获得类对象
        //2、根据类对象获取，获取指定的Field对象
        //field对象相当于从整个图纸中获取了一个局部的部分
        //括号中加上需要获取的属性的名字
        Field field = catClass.getDeclaredField("name");
        field.setAccessible(true);//专门处理private成员
        //3、根据图纸来修改或者获取对象的相关字段
        Cat cat = new Cat();//创建一个对象
        //通过get方法获取cat这个对象中一个名为name的属性
        String name = (String) field.get(cat);
        System.out.println(name);
        //通过set方法修改cat这个对象中一个名为name的属性
        field.set(cat,"mimi");
        String name1 = (String) field.get(cat);
        System.out.println(name1);
    }
    //通过反射来实例化对象
    public static void testInstance() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class catClass = Class.forName("反射的使用.Cat");//获得类对象
        Cat cat = (Cat) catClass.newInstance();

    }

    public static void testMethod() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
       //1、先获取类对象
       Class catClass = Class.forName("反射的使用.Cat");//获得类对象
       //2、根据类对象，根据名字获取到指定的Method对象
       // getMethod 从第二个参数开始，其实就是用来描述当前eat对应的方法应该是哪个版本

       Method method = catClass.getMethod("eat",String.class);//调用一个参数的eat方法
       Method method1 = catClass.getMethod("eat",String.class,String.class);//调用两个个参数的eat方法
       //3、借助Method对象来调用指定的方法（对于非静态方法，需要指定实例进行调用）
       Cat cat = new Cat();
       method.setAccessible(true);
       method1.setAccessible(true);
       method.invoke(cat,"鱼");//前面是要调用的对象，后面是传入调用方法的参数
       method1.invoke(cat,"鱼","肉");

   }
    public static void testConstructor() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //1、先获取类对象
        Class catClass = Class.forName("反射的使用.Cat");//获得类对象
        //2、借助类对象获取Constructor对象
        //获取到参数为一个String 的构造方法
        Constructor constructor = catClass.getConstructor(String.class);
        constructor.setAccessible(true);//访问私有的构造函数
        //3、根据Constructor 实例化对象
        Cat cat = (Cat) constructor.newInstance("小黑");
        cat.eat("猫粮");
    }

    public static void main(String[] args) throws IllegalAccessException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        teatField();
        testMethod();
        testInstance();
        testConstructor();

    }

}
