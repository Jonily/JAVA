package 阻塞队列;

public class ThreadDemo {
    static class BlockingQueue{
        //普通队列实现
        //1、基于链表
        //2、基于数组
        private int[] array = new int[1000];
        private volatile int head = 0;
        private volatile int tail = 0;
        //head 和 tail构造出前闭后开的区间
        // 当两者重合的时候, 可能是表示队列空, 也可能是表示队列满.
        // 为了区分空还是满, 就需要额外引入一个 size 来表示.
        private volatile int size = 0;



        // 队列的基本操作
        // 1. 入队列
        // 2. 出队列
        // 3. 取队首元素
        // 针对阻塞队列来说, 只提供前两个操作, 不支持取队首元素.

        // 阻塞版本的入队列, 为了和之前的版本区分, 用了不同的名字.
        public void put(int value) throws  InterruptedException {
            synchronized (this){//获取到锁才能进行后面的
                while (size == array.length){
                    wait();
                }
                //把value 放到队尾
                array[tail] = value;
                tail++;
                if(tail == array.length){
                    tail = 0;
                }
                size++;
                notify();
            }

        }

        //阻塞队列的出队列
        public int take() throws InterruptedException{
            int ret = 0;
            synchronized (this){
                while(size == 0){
                    wait();
                }
                 ret = array[head];
                head++;
                if(head == array.length){
                    head = 0;
                }
                size--;
                notify();
            }
            return ret;
        }
    }

    //弄两个线程，分别模拟生产者和消费者
    //1、消费者快，生产者慢，消费者会阻塞等待,每次有新生产元素，消费者才能消费
    //2、让消费者慢，生产者快，生产者线程刚开始的时候会快速的往队列中插入元素, 插入满了之后就会阻塞等待.
    // 随后消费者线程每次消费一个元素, 生产者才能生产新的元素.
    public static void main(String[] args) {
        BlockingQueue blockingQueue = new BlockingQueue();
        Thread producer = new Thread() {
            @Override
            public void run() {
                for (int i = 0;i < 10000; i++) {
                    try {
                        blockingQueue . put(i);
                        System.out.println("生产元素:"+ i);
                        //Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e. printStackTrace();
                    }
                }
            }
        };
        producer . start();

        Thread consumer = new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        int ret = blockingQueue.take();
                        System.out.println("消费元素: " + ret);
                        System.out.println();
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        consumer.start();
    }
}
