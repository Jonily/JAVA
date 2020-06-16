package 线程中断;

public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread("hh"){
            @Override
            public void run() {
                for (int i = 0; i < 10 ; i++) {
                    System.out.println(Thread.currentThread().getName());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //run方法的执行过程就代表着系统内线程的生命周期
                //run方法执行中，内核的线程就存在
                //run方法执行完毕，内核中的线程随之销毁
                System.out.println("线程退出");
            }
        };
        //只要线程创建完毕，属性不变
        System.out.println(t.getName());
        System.out.println(t.getPriority());
        System.out.println(t.isDaemon());
        System.out.println(t.getId());
        //会随着线程的运行过程发生变化
        System.out.println();
        System.out.println(t.isAlive());
        System.out.println(t.isInterrupted());
        System.out.println(t.getState());

        t.start();
        while (t.isAlive()){
            System.out.println("hh 正在运行");
            System.out.println(t.getState());
            System.out.println(t.isInterrupted());
            Thread.sleep(300);

        }
    }
}
