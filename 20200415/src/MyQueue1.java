/**
 * @Description:
 * @Author HuangZhuoLin
 * @Date 2020/4/16 9:36
 */
//基于顺序表（数组），构成了循环队列
public class MyQueue1 {
    //定义数组
    private int[] array = new int[100];
    private int head = 0;//指向队首
    private int tail = 0;//指向队尾
    private int size = 0;//有效数据个数



    //入队列
    public boolean push(int val){
        if(size == array.length){
            return false;
        }
        array[tail] = val;
        tail++;
        //如果尾超过数组长度返回队首
        if(tail >= array.length){
            tail = 0;
        }
        //tail = tail % array.length
        size++;
        return true;
    }


    //出队列
    public Integer pop(){
        if(size == 0){
            return null;
        }
        int ret = array[head];
        head++;
        //如果头超过数组长度则返回队首
        if(head >= array.length){
            head = 0;
        }
        size--;
        return ret;
    }

    //取队首元素
    public Integer peak(){
        if(size == 0){
            return null;
        }
        return array[head];
    }
    public static void main(String[] args) {
        MyQueue1 myQueue1 = new MyQueue1();
        myQueue1.push(1);
        myQueue1.push(2);
        myQueue1.push(3);
        System.out.println(myQueue1.peak());

        while (true){
            Integer cur = myQueue1.pop();
            if(cur == null){
                break;
            }
            System.out.println(cur);
        }
    }
}
