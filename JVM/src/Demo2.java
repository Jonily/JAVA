import java.util.concurrent.atomic.AtomicInteger;

public class Demo2 {
   // private static int num = 0;

    private static AtomicInteger num = new AtomicInteger(0);
    public static void main(String[] args) throws InterruptedException {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 50000 ; i++) {
                   synchronized (Demo2.class){
                       num.getAndIncrement();//num++
                       //num.incrementAndGet();//++num

                   }
                }
            }
        };

        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(num);

    }
}
