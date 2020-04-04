package TestDemo;

/**
 * @Description:
 * @Author HuangZhuoLin
 * @Date 2020/4/4 9:21
 */
class Person implements Cloneable{
    public  int age;

    public Person(int age){
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                '}';
    }
}
public class TestDemo {
    public static void main(String[] args) {
        Person person = new Person();
        person.clone();
    }
}
