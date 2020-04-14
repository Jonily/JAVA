package 栈和队列;

/**
 * @Description:
 * @Author HuangZhuoLin
 * @Date 2020/4/14 19:02
 */

public class MyStack {
    //可以基于顺序表也可以基于链表
    private int[] array = new int[100];
    // array中[0，size)区间中的元素是栈中的有效元素
    //0号为栈底，size-1为栈顶
    private int size = 0;


    //入栈
    public void push(int value){
        //此处无扩容
        array[size] = value;
        size++;
    }

    //出栈
    public Integer pop(){
        if( size <= 0){
            return null;
        }
        int ret = array[size-1];
        size--;
        return ret;
    }
    //取栈顶
    public Integer peek(){
        if( size <= 0){
            return null;
        }
        int ret = array[size-1];
        return ret;
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);


        Integer cur = null;
        while ((cur = myStack.pop()) != null){
            System.out.println(cur);
        }

    }


}
