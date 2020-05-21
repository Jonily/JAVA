public class ThreadTest extends Thread {
    public String name;
    public long time;

    public ThreadTest(String name, long time) {
        this.name = name;
        this.time = time;
    }
    public void run(){//线程需要具体执行的任务
        for(int i = 1; i <= 10; i++){
            System.out.println(name + ": 第" + i + "次循环");
            try{
                sleep(time); //每执行一次循环，休眠一定的时间，调用休眠的方法需要捕捉异常
            } catch (InterruptedException e){

            }

        }

    }
}
class Test1{
    public static void main(String[] args) {
        ThreadTest th1 = new ThreadTest("线程A",300);
        ThreadTest th2 = new ThreadTest("线程B",300);
        th1.setPriority(10);//设置优先级
        th2.setPriority(Thread.MIN_PRIORITY);
        th1.start();
        th2.start();//线程对象在创建完后需要调用start方法来排队等待获取cpu资源
    }
}
