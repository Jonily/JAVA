package 创建线程;

public class Create1 {
    //匿名内部类
    //创建了一个没有名字的类，只知道这类继承自Thread{}中是这个类的具体代码
    //同时也会new出这个类的实例
    Thread t = new Thread() {
        @Override
        public void run() {
            System.out.println("我是一个线程");
            while (true){
            }
        }

    };
    public static void main(String[] args) {
        //当Thread对象创建出来的时候内核中并没有随之产生一个线程
        Create1 create1 = new Create1();
        create1.t.start();
        //执行了start（）方法才会创建一个新线程，此时内核中出现了一个pcb
        //这个pcb就会让cpu执行对应的代码，例如上面的run方法
        while (true){

        }
    }
}
