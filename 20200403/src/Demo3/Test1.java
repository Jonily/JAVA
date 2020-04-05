package Demo3;



/**
 * @Description:
 * @Author HuangZhuoLin
 * @Date 2020/4/5 21:16
 */
import java.util.Arrays;
class Student implements Comparable<Student>{
    public String name;

    public  int age;
    public int score;

    public Student(String name, int age, int score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    @Override
    public int compareTo(Student o) {
        if(this.age<o.age){
            return -1;
        }
        if(this.age==o.age){
            return 0;
        }
        return 1;
        //return this.age-o.age;
        //return this.name.compareableTo(o.name);  字符串的比较大小
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }
}
public class Test1 {
    public static void main(String[] args) {
        Student[] students = new Student[3];
        students[0] = new Student("一号",10,90);
        students[1] = new Student("二号",16,94);
        students[2] = new Student("三号",12,20);
        Arrays.sort(students);//排序需要实现Compareable接口

        //把数组中的元素转化为字符串时， 会调用Student类中的toString方法
        System.out.println(Arrays.toString(students));

//重写可以打印数组中的数据否则只会打印出地址的哈希值

    }
}
