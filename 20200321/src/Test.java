/**
 * @Description:
 * @Author HuangZhuoLin
 * @Date 2020/3/21 22:24
 */
class Person{
    private String name;
    private String sex;
    private int age;
    public Person(String name,String sex,int age){
        this.age = age;
        this.name = name;
        this.sex = sex;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public void show(){
        System.out.println(name+" "+"性别："+sex+" "+"年龄为："+age);
    }
    public void play(){
        System.out.println(name+"喜欢打篮球。");
  }
    public void eat(){
        System.out.println("吃饭。");
    }
    public void sleep(){
        System.out.println("睡觉。");
    }
}
       public class Test{
           public static void main(String[] args) {
               Person person1 = new Person("韦德","男",39);
               Person person2 = new Person("詹姆斯","男",36);
               Person person3 = new Person("科比","男",40);
               person1.show();
               person1.play();
               person1.eat();
               person2.show();
               person2.play();
               person2.eat();
               person3.show();
               person3.play();
               person3.eat();
           }
}
