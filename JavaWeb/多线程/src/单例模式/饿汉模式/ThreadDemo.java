package 单例模式.饿汉模式;

public class ThreadDemo {
    //创建类
    //饿汉模式
    static class Singleton{
        //把构造方法、变成私有，此时在此类外面就无法new这个类的实例
        //饿汉模式，”饿“是值只要类被加载，实例就会立刻创建（实例创建时机比较早）
        private Singleton(){
            //再创建一个static成员，表示Singleton类的唯一实例
            //static 和类相关，和实例无关，类在内存中只有一份，static成员也只有一份
        }
        private static Singleton instance = new Singleton();
            public static Singleton getInstance(){
                return instance;
            }
        public static void main(String[] args) {
            //getuinstance()是获取实例的唯一方式
            Singleton singleton = Singleton.getInstance();
            Singleton singleton1 = Singleton.getInstance();
            System.out.println(singleton == singleton1);
        }
    }
}
