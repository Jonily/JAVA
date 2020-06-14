package 线程池;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class ThreadDemo {
    static class Worker extends Thread {
        //这个类用来描述当前工作的线程
        //每个work线程都需要从任务列表中取任务
        //需要能够获取到任务队列的实例
        private int id = 0;
        private BlockingDeque<Runnable> queue = null;
        public Worker(BlockingDeque<Runnable> queue,int id){
            this.queue = queue;
            this.id = id;
        }
        @Override
        public void run() {
            try{
                //try将while包裹
                //目的是只要线程收到异常，就会立刻结束run方法（结束线程）
                while (!Thread.currentThread().isInterrupted()){
                    Runnable command = queue.take();
                    System.out.println("thread" + id + "running...");
                    command.run();
                }
            }catch (InterruptedException e){
                //线程结束
                System.out.println("线程被终止");
            }
        }
    }
    //本质上是一个生产者消费者模型
    //调用execute 的代码就是生产者，生产了任务（Runnable对象）
    //worker 线程就是消费者，消费了队列中的任务
    //交易场所就是BlockingQueue
    static class MyThreadPool {
        //这个阻塞队列用来组织若干个任务
        private BlockingDeque<Runnable> queue = new LinkedBlockingDeque<>();
        //这个list用来组织若干个工作线程
        private List<Worker> workers = new ArrayList<>();
        //一个线程内部应该有多少个线程，需要根据实际情况来确定
        //当前的10是自己先设定
        private static final int maxWorkerCount = 10;
        //实现execute方法和shutdown方法
        public void execute(Runnable command) throws InterruptedException {
            //也是使用延时加载的方式来创建线程
            //当前线程池中的线程数目比较少的时候，就创建线程来作为工作线程
            //如果线程数目已经较多了（达到设定的值），就不用新建线程
            if (workers.size() < maxWorkerCount){
                Worker worker = new Worker(queue,workers.size());
                worker.start();
                workers.add(worker);
            }
            queue.put(command);
        }
        //当shutdown结束后，意味着所有的线程一定都结束了
        public void shutdown() throws InterruptedException {
            //终止所有线程
            for(Worker worker : workers){
                worker.interrupt();
            }
            //还需等待每个线程执行结束
            for(Worker worker : workers){
                worker.join();
            }
        }
    }
    static class Command implements Runnable {
       private int num;
        public Command(int num){
            this.num = num;
        }
        @Override
        public void run() {
            System.out.println("正在执行任务" + num);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyThreadPool pool = new MyThreadPool();
        for (int i = 0; i < 2000 ; i++) {
           pool.execute(new Command(i)) ;
        }
        Thread.sleep(2000);
        pool.shutdown();
        System.out.println("线程池已经被销毁");
    }
}
