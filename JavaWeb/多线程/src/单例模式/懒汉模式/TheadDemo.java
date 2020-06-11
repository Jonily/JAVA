package 单例模式.懒汉模式;

import 单例模式.饿汉模式.ThreadDemo;

public class TheadDemo {
    //使用懒汉模式进行实现Singleton 类被加载的时候，不会立刻实例化
    //等到第一次使用这个实例的时候再进行实例化
    static class Singleton {
        private Singleton() {
        }

        private volatile static Singleton instance = null; //类加载的时候没有实例化

         public static Singleton getInstance() {
            if (instance == null) {
                synchronized (Singleton.class) {
                    if (instance == null) {
                        instance = new Singleton();//第一次调用getInstance时才能实例化
                    }//如果代码一整场都没有调用getInstance，此时实例化的过程也就省略了

            }
        }
            return instance;
        }
    }
}
