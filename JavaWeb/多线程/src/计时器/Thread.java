package 计时器;

import java.util.concurrent.PriorityBlockingQueue;

public abstract class Thread {
    public abstract void run();

    //优先队列中的元素必须是可比较的
    //比较规则的指定主题是两种方式
    //1、让Task实现Compare接口
    //2、让优先队列构造的时候，传入一个比较器对象（Compareor）
    static class Task implements Comparable<Task> {
        //Runnable 中有一个run方法，就可以借助这个run方法来描述要执行的具体任务是啥
        private Runnable command;
        //time表示啥时候来执行command
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
    static class Worker extends Thread {
        private PriorityBlockingQueue<Task> queue = null;

        private Worker(PriorityBlockingQueue<Task> queue){
            this.queue = queue;
        }
        @Override
        public void run(){
            //实现具体的线程执行的内容
            while (true){
                try{
                    //1、取出队首元素，检查时间是否到了
                    Task task = queue.take();
                    //2、检查当前任务时间是否到了
                    long curTime = System.currentTimeMillis();
                    if(task.time > curTime){
                        //时间还没到
                        queue.put(task);
                    }else {
                        task.run();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
            }
        }
    }
    static class Timer{
        //定时器的基本构成，有三个部分
        //1、用一个类来描述任务
        //2、用一个阻塞优先队列来组织若干个任务，让队首元素是最早时间的任务
        //如果队首元素时间未到，那么其他的元素也肯定不能执行
        private PriorityBlockingQueue<Task> queue = new PriorityBlockingQueue<>();
        //3、用一个线程来循环扫描当前的阻塞队列的队首元素，如果时间到，就执行指定任务
        public Timer() {
            //构造线程
            Worker worker = new Worker(queue);

        }




    }
}
