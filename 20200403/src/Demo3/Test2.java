package Demo3;

/**
 * @Description:
 * @Author HuangZhuoLin
 * @Date 2020/4/5 21:58
 */
//自定义类型拷贝
    class Money implements Cloneable{
        public double money = 19.9;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
class Person implements Cloneable{
    public int age;
    public Money m;

    public Person(int age) {
        this.age = age;
        m = new Money();
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                '}';
    }

    @Override
    /*protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }*/
    protected Object clone() throws CloneNotSupportedException {
        Person person1 =  (Person) super.clone();
        person1.m = (Money) this.m.clone();
        return person1;
    }
}
public class Test2 {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person person = new Person(10);
        Person person1 =(Person) person.clone();
        System.out.println(person.m.money);
        System.out.println(person1.m.money);
        person.m.money = 20;
        System.out.println("===================");
        System.out.println(person.m.money);
        System.out.println(person1.m.money);
    }
    public static void main1(String[] args) throws CloneNotSupportedException {
        Person person = new Person(10);
        Person person1 =(Person) person.clone();
        System.out.println(person.age);
        System.out.println(person1.age);
        System.out.println("=====通过person1修改age==========");
        person1.age = 99;
        System.out.println(person.age);
        System.out.println(person1.age);


       /* try{
        Person person1 =(Person) person.clone();
    }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }*/
    }
}
