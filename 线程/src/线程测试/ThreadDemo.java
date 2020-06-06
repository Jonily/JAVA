package 线程测试;

public class ThreadDemo {
    static class MyTread extends Thread{
        @Override
        public void run() {
            System.out.println("我是一个线程");
        }
    }
    public static void main(String[] args) {
        //创建线程需要使用Thread类，创建一个Thread实例
        //给线程指定需要执行的代码
        //继承Thread类
        //重写run方法
        Thread t = new MyTread();
        //执行start方法创建一个线程
        t.start();//调用类中的run方法
    }
}
