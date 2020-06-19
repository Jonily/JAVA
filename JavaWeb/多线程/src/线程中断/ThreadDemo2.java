package 线程中断;

public class ThreadDemo2 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(){
            @Override
            public void run() {
                //直接使用线程内部的标记位进行判定
                while (! Thread.currentThread().isInterrupted()) {
                    System.out.println("别烦我，在转账");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }
                }
                System.out.println("转账操作被终止");
            }
        };
        t.start();
        Thread.sleep(5000);
        System.out.println("停止");
        t.interrupt();//强制中断
    }
}
