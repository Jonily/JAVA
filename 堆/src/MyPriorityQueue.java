/**
 * @Description:
 * @Author HuangZhuoLin
 * @Date 2020/4/30 0:39
 */

public class MyPriorityQueue {
    private int[] array = new int[100] ;
    private int size = 0;

    public void offer(int x){
        array[size] = x;
        size++;
        shiftUp(array,size,size-1);
    }
    private void shiftUp(int[] array,int size,int index){
        int child = index;
        int parent = (child - 1)/2;
        while (child > 0){
            if(array[parent] > array[child]){
                int tmp = array[child];
                array[child] = array[parent];
                array[parent] = tmp;
            }else {
                break;
            }
            child = parent;
            parent = (child -1)/2;
        }
    }
    public Integer poll(){
        if(size <= 0){
            return null;
        }
        int ret = array[0];
        array[0] = array[size-1];
        size--;
        shiftDown(array,size,0);
        return ret;
    }
    private void shiftDown(int[] array,int size,int index){
        int parent = index;
        int child = 2 * parent + 1;
        while (child < size){
            if(child + 1 < size && array[child+1] < array[child]){
                child = child+1;
            }
            if(array[parent] > array[child]){
                int tmp = array[child];
                array[child] = array[parent];
                array[parent] = tmp;
            }else {
                break;
            }
            parent = child;
            child = 2 * parent + 1;
        }
    }

    public Integer peek(){
        if(size == 0){
            return null;
        }
        return array[0];
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public static void main(String[] args) {
        MyPriorityQueue myPriorityQueue = new MyPriorityQueue();
        myPriorityQueue.offer(5);
        myPriorityQueue.offer(6);
        myPriorityQueue.offer(9);
        myPriorityQueue.offer(1);
        myPriorityQueue.offer(3);
        myPriorityQueue.offer(0);
        myPriorityQueue.offer(7);
        while (!myPriorityQueue.isEmpty()){
            Integer cur = myPriorityQueue.poll();
            System.out.print(cur+" ");
        }

    }
}
