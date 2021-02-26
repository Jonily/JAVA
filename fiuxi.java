public class Test{
    public static void main(String[] args) {
        new Thread(()->{

        }).start();
    }
}

class Data {
     Lock lock = new ReentrantLock();
     private int num = 0;
     Condition condition = new lock.newCondition();

     public synchronized void incrment(){
        lock.lock();
        try{
            while(num != 0){
                condition.await();
            }
            num++;

            condition.singnalAll();

        }catch(InterruptedException e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }

     }

     public synchronized void decrment(){
        lock.lock();
        try{
            while(num == 0){
                condition.await();
            }
            num--;

            condition.singnalAll();

        }catch(InterruptedException e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
     }
}

public class Hungry{
    private Hungry(){

    }

    private static Hungry Hungry = new  Hungry();
    public static Hungry get(){
        return hungry;
    }
}


public class Lazy{
    private Lazy(){

    }

    private volatile static Lazy lazy;

    public static Lazy get(){
        if(lazy == null){
            synchronized(lazy.class){
                if(lazy == null){
                    lazy = new Lazy();
                }

            }
        }
        return lazy;
    }
}