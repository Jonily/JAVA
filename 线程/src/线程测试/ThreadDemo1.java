package 线程测试;

public class ThreadDemo1 {
    private static long count = 1000000000;
    public static void main(String[] args) {
        seriaL();
        concurrency();
    }
    private static void seriaL(){

        long beg = System.currentTimeMillis();//获取当前的时间戳
        int a = 0;
        for (long i = 0; i < count ; i++) {
            a++;

        }
        int b = 0;
        for (long i = 0; i< count;i++){
            b++;

        }
        long end = System.currentTimeMillis();
        System.out.println(end - beg);
    }
    private  static void concurrency(){

    }
}
