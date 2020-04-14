package 栈和队列;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Description:
 * @Author HuangZhuoLin
 * @Date 2020/4/14 20:56
 */

public class TestStackAndQueue {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);


        //标准库中的Stack如果针对空栈进行 pop或者peak就会抛出异常
        while (!stack.empty()){
            Integer cur = stack.pop();
            if(cur == null){
                break;
            }
            System.out.println(cur);
        }
        //由于标准库中的Stack是继承Vecto的类 Vector可以做的Stack也可以
        //Stack并没有限制灵活性，反而增加了代码的复杂程度，
        // 使用的时候尽量避免使用非Stack的方法


        //标准库中的队列是一个接口
        //实例化一个实现Queue接口的类
        //标准库中的队列是基于链表实现的
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);

        while (!queue.isEmpty()){
            Integer cur = queue.poll();
            System.out.println(cur);
        }


    }
}
