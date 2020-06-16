package 创建线程;

public class Create3 {
        public static void main(String[] args) {
            //通过匿名内部类实现Runnable接口
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    System.out.println("我是一个新线程");
                }
            };
            Thread t = new Thread(runnable);
            t.start();
        }

    }

