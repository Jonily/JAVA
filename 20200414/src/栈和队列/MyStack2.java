package 栈和队列;

/**
 * @Description:
 * @Author HuangZhuoLin
 * @Date 2020/4/14 19:13
 */
//使用链表实现，用链表头部代表栈顶尾部代表栈底
public class MyStack2 {
    static class Node{


        public int vail;
        public Node next;
        public Node(int vail) {
            this.vail = vail;
            this.next = null;
        }
    }
    //只要知道头结点就可以获取到后面的所有的节点
    //一般表示链表都是使用一个头结点来表示整个链表
    //用局部表示整个整体
    //链表有八种：
    //1、有环的不带环的
    //2、单向的双向的
    //3、带傀儡节点不带傀儡节点
    Node head = new Node(-1);

    public void push(int value){
        //头插

        Node newNode = new Node(value);
        newNode.next = head.next;
        head.next = newNode;
    }
    public Integer pop(){
        //头删带傀儡节点
        Node toDelete = head.next;
        if(toDelete == null){
            return null;
        }
        head.next = toDelete.next;
        return toDelete.vail;
    }
    public Integer peak(){
        if(head.next == null){
            return null;
        }
        return head.vail;
    }


}
