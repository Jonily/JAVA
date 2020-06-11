public class Create {
    static class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("我是一个线程");
            while (true){
            }
        }
    }
    //创建线程需要使用Thread 类，来创建一个Thread 的实例，
    //另一方面还需要给这个线程指定，要执行哪些指令/代码.
    //指定指令的方式有很多种方式，此处先用种简单的，直接继承 Thread 类，
    //重写Thread类中的run方法.
    public static void main(String[] args) {
        //当Thread对象创建出来的时候内核中并没有随之产生一个线程
        MyThread myThread = new MyThread();
        //执行了start（）方法才会创建一个新线程，此时内核中出现了一个pcb
        //这个pcb就会让cpu执行对应的代码，例如上面的run方法
        myThread.start();
        while (true){

        }
    }
}
