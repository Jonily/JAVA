import java.util.Map;
import java.util.TreeMap;

class Student{
    public Student(String name, int age, String grade, String school) {
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.school = school;
    }

    public String name;
    public int age;
    public String grade;
    public String school;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", grade='" + grade + '\'' +
                ", school='" + school + '\'' +
                '}';
    }
}

public class TestMap {
    public static void main(String[] args){
        Student student1 = new Student("x",20,"大一","陕科大");
        Map<String,Student> studentMap = new TreeMap<>();
        studentMap.put(student1.name,student1);

        String name = "x";

        Student student = studentMap.get(name);
        System.out.print(student);

        //按照其他映射查找，需要其他map
        Map<Integer,Student> studentMap2 = new TreeMap<>();
        
        Student student2 = studentMap2.get(20);
        System.out.print(student2);


    }
}
