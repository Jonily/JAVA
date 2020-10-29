public class MyThread {
    public static void main(String[] args) {
        Thread thread = new Thread(){
            @Override
            public void run() {
                System.out.println("1");
            }
        };
        thread.setName("t1");

        thread.start();
        System.out.println("main");

    }
}
