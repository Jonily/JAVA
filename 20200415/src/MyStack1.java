/**
 * @Description:
 * @Author HuangZhuoLin
 * @Date 2020/4/15 15:58
 */
//通过链表实现栈
public class MyStack1 {
    //定义链表
    static class Node{
        public int val;
        public Node next;

        public Node(int val) {
            this.val = val;
        }
    }
    Node head = new Node(-1);

    //入栈，单链表头插法
    public void push(int val){
        Node newNode = new Node(val);
        newNode.next = head.next;
        head.next = newNode;
    }

    //出栈 单链表头删
    public Integer pop(){
        Node toDelete = head.next;
        if(toDelete == null){
            //栈为空
            return null;
        }
        head.next = toDelete.next;
        return toDelete.val;
    }

    //取栈顶
    public Integer peak(){
        if(head.next == null){
            //栈为空
            return null;
        }
        return head.next.val;

    }

    public static void main(String[] args) {
        MyStack1 myStack1 = new MyStack1();
        myStack1.push(1);
        myStack1.push(2);
        myStack1.push(3);
        System.out.println(myStack1.peak());

        while (true){
            Integer cur = myStack1.pop();
            if(cur == null){
                break;
            }
            System.out.println(cur);
        }
    }
}
