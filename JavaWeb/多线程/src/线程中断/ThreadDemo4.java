package 线程中断;

public class ThreadDemo4 {
    public static void main(String[] args) {
        for (Thread.State s: Thread.State.values()
             ) {
            System.out.println(s);
        }
    }
}
