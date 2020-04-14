package 栈和队列;

/**
 * @Description:
 * @Author HuangZhuoLin
 * @Date 2020/4/14 19:52
 */

public class MyQueue {
    //实现队列也可以使用链表也可以顺序表
    //链表实现简单
    //链表尾部作为队尾（方便插入元素），头部作为队首（方便删除元素）
    //为了方便实现尾插，多设置一个引用指向链表的尾部
    static class Node{
        public Node(int val) {
            this.val = val;
        }

        public int val;
        public Node next;

    }

    private Node head = new Node(-1);
    private Node tail = head;

    //private int size;//队列中元素个数
    //入队列，尾插
    public void offer(int value){
        Node newNode = new Node(value);
        tail.next = newNode;
        //更新尾部指向
        tail = tail.next;
    }

    //出队列，链表头删
    public Integer poll(){
        if(head.next == null){
            //队列为空 出队列失败
            return null;
        }
        Node toDelete = head.next;
        head.next = toDelete.next;
        //更新尾部
        if(head.next == null){
            //此时队列为空
            //让tail再指向傀儡节点
            tail = head;
        }
        return toDelete.val;
    }

    //取队首元素
    public Integer peak (){
        if(head.next == null){
            return null;
        }
        return head.next.val;

    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        while (true){
            Integer cur = queue.poll();
            if(cur==null){
                break;
            }
            System.out.println(cur);
        }

    }
}
