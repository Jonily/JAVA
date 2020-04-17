

/**
 * @Description:
 * @Author HuangZhuoLin
 * @Date 2020/4/16 10:05
 */
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
public class TestStackQueue {
    public static void main(String[] args) {
        System.out.println("==============");
        Stack<String> stack = new Stack<>();
        stack.push("科比");
        stack.push("韦德");
        stack.push("詹姆斯");
        stack.push("乔丹");
        while (! stack.empty()) {
            System.out.println(stack.pop());
        }
        System.out.println("===============");
        //在Java库中Queue是个j接口不能直接实例化对象
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(45);
        queue.offer(52);
        queue.offer(63);
        while (! queue.isEmpty()) {
            System.out.println(queue.poll());
        }

    }
}
