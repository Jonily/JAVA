package test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class TestGson {

   static class Student{
        private String name;
        private int id;
        private double score;

        public Student(String name, int id, double score) {
            this.name = name;
            this.id = id;
            this.score = score;
        }
    }
  /*  public static void main(String[] args) {
        //1、实例化Gson对象（工厂模式）
        Gson gson = new GsonBuilder().create();

        //2、把一个对象转成json字符串
        Student student = new Student("hh",10,45.6);
        String jsonString = gson.toJson(student);//把student转成json
        System.out.println(jsonString);

        //3、把json转成对象
        String s = "{\"name\":\"hh\",\"id\":10,\"score\":45.6}";
        Student student1 = gson.fromJson(s,Student.class);
        System.out.println(student1.id+","+student1.name+","+student1.score);
    }*//*尤其是在把JSON字符串解析成对象的时候,
    GSON这个库就需要知道目标的对象中都有哪些属性,每个名字叫啥,类型是啥.*//*

*/
}
