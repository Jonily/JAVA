public class Demo4 {
    private static int i =0;
    public static void main(String[] args) {
        //假设是多线程
        synchronized (Demo4.class){
            for (int j = 0; j <10000 ; j++) {
                i++;
            }
        }

        for (int j = 0; j <10000 ; j++) {
            synchronized (Demo4.class){
                i++;

            }
        }
    }
}
