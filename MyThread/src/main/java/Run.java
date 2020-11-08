public class Run {
    public static void main(String[] args) {
        for (int i = 0; i <100 ; i++) {
             new Thread(){
                @Override
                public void run() {
                    System.out.println(1);
                    try{
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }

    }
}
