class Data{
	private int num;

	public synchronized void add(int num){
		if(num != 0){
			this.wait;
		}
		num++;
		this.notifAll();

	}
	public synchronized void decrement(int num){
		if(num == 0){
			this.wait;
		}
		num--;
		this.notifAll();
	}


}

public class Main{
	public static void main(String[] args){
    	Data data = new Data();
    	new Thread(()->{
    		for(int i = 0;i<10;i++){
    			data.add;
    		}
    	},"A").start;

    	new Thread(()->{
    		for(int i = 0;i<10;i++){
    			data.add;
    		}
    	},"B").start;

	}

}
