package 栈和队列;

/**
 * @Description:
 * @Author HuangZhuoLin
 * @Date 2020/4/14 20:09
 */
//顺序表写队列
public class MyQueue2 {
    private int[] array = new int[100];
    //head，tail 前闭后开队列中无元素
    private int head = 0;
    private int tail = 0;
    private int size = 0;


    //如果插入失败，返回flase，如果插入成功返回true
    public boolean offer(int value){
        if(size == array.length){
            return false;
        }
        array[tail] = value;
        tail++;
        if(tail >= array.length){
            tail = 0;
        }
        //tail = tail % array.length;  求模（0-length-1）
        size++;
        return true;
    }

    //出队列
    public Integer poll(){
        if(size == 0){
            return null;
        }
        //如果队列非空 返回head位置元素，head++ 删除该元素
        int ret = array[head];
        head++;
        if( head  >= array.length){
            head  = 0;
        }
        size--;
        return ret;
    }


    public Integer peak(){
        if(size == 0){
            return null;
        }
        return array[head];
    }

    public static void main(String[] args) {
        MyQueue2 myQueue2 = new MyQueue2();
        myQueue2.offer(1);
        myQueue2.offer(2);
        myQueue2.offer(3);
        while (true){
            Integer cur = myQueue2.poll();
            if(cur == null){
                break;
            }
            System.out.println(cur);

        }
    }


}
