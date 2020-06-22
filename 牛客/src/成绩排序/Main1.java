package 成绩排序;

import java.util.*;


public class Main1 {
    static class Student {
        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String name ;
        public int age;
        @Override
        public String toString() {
            return name +" " + age;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int num = in.nextInt();
            int type = in.nextInt();
            List<Student> student = new ArrayList<>();
            for (int i = 0; i < num ; i++) {
                student.add(new Student(in.next(),in.nextInt()));
            }
                Collections.sort(student, new Comparator<Student>() {
                    @Override
                    public int compare(Student o1, Student o2) {
                        if (type == 1){
                            return o1.age - o2.age;
                        }
                            return o2.age - o1.age;
                    }
            });
            for (Student s : student) {
                System.out.println(s);
            }

        }
    }

}


