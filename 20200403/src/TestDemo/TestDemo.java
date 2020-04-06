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
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                '}';
    }
}
public class TestDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person person = new Person(2);
        person.clone();
    }
}
