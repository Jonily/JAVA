import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class MyFurtureTask {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> task = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println(111);
                Thread.sleep(1000);
                return 100;
            }
        });
        Thread t = new Thread(task);//定义线程类代入task
        t.start();

        System.out.println(task.get());//获取task中的返回值
    }
}
