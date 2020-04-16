/**
 * @Description:
 * @Author HuangZhuoLin
 * @Date 2020/4/15 9:33
 */

public class MyStack {
    //基于顺序表，创建数组
    private int[] array = new int[100];
    //定义一个size用来计数数组中的存储元素数量
    private int size = 0;

    //入栈
    public void push(int value){
        array[size] = value;
        size++;
    }

    //出栈
    public Integer pop(){
        //判断栈是否为空
        if(size <= 0){
            return null;
        }
        int ret = array[size-1];
        size--;
        return ret;
    }


    //取栈顶元素
    public Integer peak(){
        if(size <= 0){
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
        while (true){
            Integer cur = myStack.pop();
            if(cur == null){
                break;
            }
            System.out.println(cur);
        }

    }

}
