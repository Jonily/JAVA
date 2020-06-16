package 创建线程;

public class Create2 {
    //显示创建一个类实现Runnable接口
    //然后把这个Runnable的实例关联到Thread实例上
    static class MyRunnable implements Runnable{
        @Override
        public void run() {
            System.out.println("我是一个新线程");
        }
    }

    public static void main(String[] args) {

      Thread t = new Thread(new MyRunnable());
        t.start();
    }

}
