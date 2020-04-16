/**
 * @Description:
 * @Author HuangZhuoLin
 * @Date 2020/4/15 17:59
 */

public class MyQueue {
    //实现队列使用链表
    //将链表表头作为队首，链表表尾作为队尾，因为是先进先出所以要进行尾插
    //为了更加方便进行尾插，所以多定义一个引用指向队尾
    static class Node{
        public int val;
        public Node next;

        public Node(int val) {
            this.val = val;
        }
    }
    Node head = new Node(-1);
    Node tail = head;


    //入队列
    public void push(int val){
        //进行尾插
        Node newNode = new Node(val);
        tail.next = newNode;
        //插入完毕后更新tail，tail始终指向最后一个
        tail = tail.next;
    }

    //出队列
    public Integer pop(){
        //头删法
        if(head.next == null){
            return null;
        }
        Node toDelete = head.next;
        head.next = toDelete.next;
        //如果删除后队列为空，让tail指回傀儡节点
        if(head.next == null){
            tail = head;
        }
        return toDelete.val;
    }

    //取队首元素

    public Integer peak(){
        if(head.next == null){
            return null;
        }
        return head.next.val;
    }
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        System.out.println(myQueue.peak());

        while (true){
            Integer cur = myQueue.pop();
            if(cur == null){
                break;
            }
            System.out.println(cur);
        }
    }
}
