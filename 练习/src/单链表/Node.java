package 单链表;

public class Node {
    private int val;
    private Node next;

    public Node(int val) {
        this.val = val;
    }
    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }
    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }


}
class MyLinkedList{
    public Node head = null;

    public MyLinkedList() {
        this.head = null;
    }
    //头插法
    public void headAdd(int data){
        Node cur = new Node(data);
        if(this.head == null){
            this.head = cur;
            return;
        }
        cur.setNext(this.head);
        this.head = cur;
    }

    //找前驱
    public Node findPrev(){
        Node prev = this.head;
        while (prev.getNext() != null){
            prev = prev.getNext();
        }
        return prev;
    }
    //尾插
    public void tailAdd(int data){
        Node cur = new Node(data);
        if(this.head == null){
            this.head = cur;
            return;
        }
        Node pre = findPrev();
        pre.setNext(cur);
    }
    //任意位置插入
    public void indexAdd(int index ,int data) {
        Node pre = this.head;
        Node cur = new Node(data);
        if(this.head == null){
            this.head = cur;
        }
        if(index < 0 || index > size()){
            throw new RuntimeException("输入下标不合法！");
        }else if(index == 0){
            headAdd(data);
        }else if(index == size()){
            tailAdd(data);
        }
        for(int i = 0; i <= index; i++){
            pre = pre.getNext();
        }
        cur.setNext(pre.getNext().getNext());
        pre.setNext(cur);

    }

    //打印单链表
    public void disPlay(){
        if (this.head == null){
            System.out.println("该链表为空！");
        }
        Node cur = this.head;
        while (cur != null){
            System.out.print(cur.getVal()+" ");
            cur = cur.getNext();
        }
    }
    //单链表长度
    public Integer size(){
        if (this.head == null){
            return null;
        }
        int count = 0;
        Node cur = this.head;
        while (cur != null){
            count++;
            cur = cur.getNext();
        }
        return count;
    }




    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.headAdd(1);
        myLinkedList.headAdd(2);
        myLinkedList.headAdd(3);
        myLinkedList.tailAdd(4);
        myLinkedList.indexAdd(1,10);

        myLinkedList.disPlay();

    }
}

