public class ThreadTest1 implements Runnable{
    public String name;
    public long time;

    public ThreadTest1(String name, long time) {
        this.name = name;
        this.time = time;
    }



    @Override
    public void run() {
        for(int i = 1; i <= 100; i++){
            System.out.println(name + ": 第" + "次循环");
            try{
                Thread.sleep(time); //每执行一次循环，休眠一定的时间，调用休眠的方法需要捕捉异常
            } catch (InterruptedException e){

            }

            }

    }
}
class Test{
    public static void main(String[] args) {
        ThreadTest1 th1 = new ThreadTest1("线程A",300);
        ThreadTest1 th2 = new ThreadTest1("线程B",300);
        Thread thread = new Thread(th1);
        thread.start();
        Thread thread1 = new Thread(th2);
        thread1.start();//线程对象在创建完后需要调用start方法来排队等待获取cpu资源
    }
}
