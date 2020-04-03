package com.bit.Test;

import java.util.Date;

public class Animals {
    public String name;
    public Animals (String name){
        this.name = name;
    }
    public void eat(String food){
        System.out.println("Animals:"+this.name+"吃"+food);
    }
}
class Dog extends Animals {
    public Dog(String name) {
        //构造父类
        super(name);
    }
    public void eat(String food){
        System.out.println("Animals:"+this.name+"吃"+food);
    }
    public void run(){
        System.out.println(this.name+"在跑");
    }
}
class Test{
    public static void func(Animals animals){
        animals.eat("面包");

    }
    public Animals func1(){
        Dog dog = new Dog("将军");
        return dog;
    }
    public static void main(String[] args) {
       //向下转型
        Animals animals = new Dog("小黑");
        //animals.eat();
        //父类引用了子类对象  向上转型
        /*Animals animals = new Dog("小黑");
        animals.eat("面包");*/
    }
}