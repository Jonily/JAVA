/**
 * @Description:
 * @Author HuangZhuoLin
 * @Date 2020/3/29 15:24
 */
class ListNode{
    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    private int data;

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    private ListNode next;

    public ListNode getPrev() {
        return prev;
    }

    public void setPrev(ListNode prev) {
        this.prev = prev;
    }

    private ListNode prev;
    public ListNode(int data){
        this.data = data;

    }
}
public class DoubleLinkedList {
    public ListNode head;
    public ListNode last;
    public DoubleLinkedList(){
        this.head = null;
        this.last = null;

    }
    //头插法
    public void addFirst(int data){
        ListNode node = new ListNode(data);
        if (this.head == null){
            this.head = node;
            this.last = node;
            return;
        }
        node.setNext(head);
        this.head.setPrev(node);
        this.head = node;

    }
    //尾插法
    public void addLast(int data){
        ListNode node = new ListNode(data);
        if(this.head == null){
            this.head = node;
            this.last = node;
            return;
        }
        this.last.setNext(node);
        node.setPrev(this.last);
        this.last = node;
    }
    //任意位置插入,第一个数据节点为0号下标
    public ListNode findIndex(int index){
        ListNode cur = this.head;
        for (int i = 0 ; i<index; i++){
            cur = cur.getNext();
        }
        return cur;
    }
    public void addIndex(int index,int data){
        if(index<0||index>size()){
            throw new RuntimeException("插入位置不合法！");
        }else if(index == 0){
            addFirst(data);
        }else if (index == size()){
            addLast(data);
        }
        ListNode node = new ListNode(data);
        ListNode cur = findIndex(index);
        node.setNext(cur);
        node.setPrev(cur.getPrev());
        cur.setPrev(node);
        node.getPrev().setNext(node);
    }
    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key){
        ListNode cur = this.head;
        while (cur!=null){
            if(cur.getData() == key){
                return true;
            }
            cur = cur.getNext();
        }
        return false;
    }
    //删除第一次出现关键字为key的节点
    public void remove(int key){
        ListNode cur = this.head;
        while (cur!=null){
            if(cur.getData() == key){
                if (cur == this.head){
                    this.head = this.head.getNext();
                    this.head.setPrev(null);
                    return;
                }else if (cur == this.last){
                    this.last = cur.getPrev();
                    this.last.setNext(null);
                    return;
                    }else {
                    cur.getNext().setPrev(cur.getPrev());
                    cur.getPrev().setNext(cur.getNext());
                    return;
                    }
                }
            cur = cur.getNext();
            }
        }


    //删除所有值为key的节点
    public void removeAllKey(int key){
        ListNode cur = this.head;
        while (cur!=null){
            if(cur.getData() == key){
                if (cur == this.head){
                    this.head = this.head.getNext();
                    this.head.setPrev(null);
                }else if (cur == this.last){
                    this.last = cur.getPrev();
                    this.last.setNext(null);
                }else {
                    cur.getNext().setPrev(cur.getPrev());
                    cur.getPrev().setNext(cur.getNext());
                }
            }
            cur = cur.getNext();
        }
    }
    //得到单链表的长度
    public int size(){
        ListNode cur = this.head;
        int count = 0;
        while (cur!=null){
            count++;
            cur = cur.getNext();
        }
        return count;
    }
    public void display(){
        ListNode cur = this.head;
        while(cur!=null){
            System.out.print(cur.getData()+" ");
            cur = cur.getNext();
        }

    }
    public void clear(){
        this.head = null;
        this.last = null;

    }
}
 class Test{
    public static void main(String[] args) {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.addFirst(1);
        doubleLinkedList.addFirst(2);
        doubleLinkedList.addFirst(66);
        doubleLinkedList.addFirst(4);
        doubleLinkedList.addLast(1);
        doubleLinkedList.addLast(2);
        doubleLinkedList.addLast(3);
        doubleLinkedList.addIndex(3,100);
        System.out.println(doubleLinkedList.contains(100));
        System.out.println(doubleLinkedList.size());
        doubleLinkedList.display();
        System.out.println();
        doubleLinkedList.remove(1);
        doubleLinkedList.display();
    }
}
