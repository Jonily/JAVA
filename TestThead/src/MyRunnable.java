
public class MyRunnable {
    public static void main(String[] args) {
        Runnable runnable = () -> {
                System.out.println(11);

        };

        Thread thread = new Thread(runnable,"t2");
        thread.start();

    }
}
class Test{
    public void test(){
        Thread thread = new Thread(()-> {
            System.out.println();},"t3");
        thread.start();

        }
}
