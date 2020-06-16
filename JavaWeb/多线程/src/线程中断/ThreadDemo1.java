package 线程中断;

public class ThreadDemo1 {
    private static boolean isQuit = false;
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(){
            @Override
            public void run() {
                while ((!isQuit)) {
                    System.out.println("别烦我，在转账");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("转账操作被终止");
            }
        };
        t.start();
        Thread.sleep(5000);
        System.out.println("终止交易");
        isQuit = true;
    }
}
