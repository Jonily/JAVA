package com.bit.Test;

public class Animals {
    public String name;
    public Animals (String name){
        this.name = name;
    }
    public void eat(String food){
        System.out.println(this.name+"吃"+food);
    }
}
class Dog extends Animals {
    public Dog(String name) {
        //构造父类
        super(name);
    }
}
class Test{
    public static void main(String[] args) {
        Dog dog = new Dog("小黑");
        dog.eat("面包");
    }
}