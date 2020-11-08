public class MyThread1 extends Thread {
    private  int i = 5;

    @Override
    public void run() {
        System.out.println("i= "+(i--)+"线程："+Thread.currentThread().getName());
    }
}
class TestThread{
    public static void main(String[] args) {
        MyThread1 myThread1 = new MyThread1();
        Thread t1 = new Thread(myThread1);
        Thread t2 = new Thread(myThread1);
        Thread t3 = new Thread(myThread1);
        Thread t4 = new Thread(myThread1);
        Thread t5 = new Thread(myThread1);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
