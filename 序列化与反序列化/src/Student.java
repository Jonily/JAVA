import java.io.*;

public class Student implements Serializable {
    public String name;
    public int age;
    public int score;
}
class IODemo {
    IODemo() throws IOException {
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
       /* Student s = new Student();
        s.name = "张三";
        s.age = 20;
        s.score = 100;
        serializeStudent(s);*/

        Student s = deserializeStudent();
        System.out.println(s.name);
        System.out.println(s.age);
        System.out.println(s.score);

    }
    private static void serializeStudent(Student s) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("D:\\test_dir\\student,txt"));
        //writeObject集序列化和写文件同时进行
        objectOutputStream.writeObject(s);
        objectOutputStream.close();
    }
    private static  Student deserializeStudent() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("D:\\test_dir\\student,txt" ));
        Student student = (Student) objectInputStream.readObject();
        return student;

    }

}

