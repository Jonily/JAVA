package 计时器;

import java.util.concurrent.PriorityBlockingQueue;

public  class ThreadDemo1 {
    //优先队列中的元素必须是可比较的
    //比较规则的指定主题是两种方式
    //1、让Task实现Compare接口
    //2、让优先队列构造的时候，传入一个比较器对象（Compareor）
    static class Task implements Comparable<Task> {
        //Runnable 中有一个run方法，就可以借助这个run方法来描述要执行的具体任务
        private Runnable command;
        //time表示啥时候来执行command,是一个绝对时间（ms级别的时间戳）
        private long time;

        //构造方法的参数表示：多少毫秒之后执行（表示的是一个相对时间）相对时间参数是为了使用方便
        public Task(Runnable command,long after){
            this.command = command;
            this.time = System.currentTimeMillis() + after;
        }

        //执行任务的具体逻辑
        public void run() {
            command.run();
        }
        @Override
        public int compareTo(Task o){
            //哪个时间小（先执行）
            return (int)(this.time - o.time);

        }
    }
    //扫描线程
    static class Worker extends Thread {
        private PriorityBlockingQueue<Task> queue = null;
        private Object mailBox = null;
        public Worker(PriorityBlockingQueue<Task> queue,Object mailBox){
            this.queue = queue;
            this.mailBox = mailBox;
        }

        public void run(){
            //实现具体的线程执行的内容
            while (true){
                try{
                    //1、取出队首元素，检查时间是否到了
                    Task task = queue.take();
                    //2、检查当前任务时间是否到了
                    long curTime = System.currentTimeMillis();//当前时间
                    if(task.time > curTime){
                        //时间还没到，就把任务再放回队列
                        queue.put(task);
                        synchronized (mailBox){
                            mailBox.wait(task.time - curTime);//等待的时间
                        }
                    }else {//时间到，直接执行
                        task.run();
                    }
                } catch (InterruptedException e) {//出现异常，直接break终止
                    e.printStackTrace();
                    break;
                }
            }
        }
    }
    static class Timer{
        //为了避免忙等需要使用wait方法
        //使用一个单独的对象辅助进行wait
        private Object mailBox = new Object();
        //定时器的基本构成，有三个部分
        //1、用一个类来描述任务
        //2、用一个阻塞优先队列来组织若干个任务，让队首元素是最早时间的任务
        //如果队首元素时间未到，那么其他的元素也肯定不能执行
        private PriorityBlockingQueue<Task> queue = new PriorityBlockingQueue<>();
        //3、用一个线程来循环扫描当前的阻塞队列的队首元素，如果时间到，就执行指定任务
        public Timer() {
            //构造线程
            Worker worker = new Worker(queue,mailBox);
            worker.start();

        }
        //4、提供一个方法，让调用者把任务安排
        // schedule 安排
        public void schedule(Runnable command,long after){
            Task task = new Task(command, after);
            queue.put(task);
            synchronized (mailBox){
                mailBox.notify();
            }
        }
    }

    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("hehe");
                timer.schedule(this,2000);//每隔两秒出现一个hehe
            }
        },5000);
    }
}
