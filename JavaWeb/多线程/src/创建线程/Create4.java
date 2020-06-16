package 创建线程;

public class Create4 {
    public static void main(String[] args) {
        //使用lambda表达式来指定线程执行的内容
        Thread t = new Thread(()-> {
            System.out.println("我是一个新线程");
        });
        t.start();
    }
}
