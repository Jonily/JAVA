import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Demo5 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //创建一个线程，计算1-1000的和

        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int ret = 0;
                for (int i = 0; i <=1000 ; i++) {
                    ret+=i;
                }
                return ret;
            }
        };

        FutureTask<Integer> futureTask = new FutureTask<>(callable);
        Thread thread = new Thread(futureTask);
        thread.start();


        //get方法堵塞，直到前面的call方法算完，才会返回
        Integer result = futureTask.get();
        System.out.println(result);


    }
}
