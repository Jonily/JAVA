/**
 * @Description: 单链表
 * @Author HuangZhuoLin
 * @Date 2020/3/24 23:38
 */
class Node{
    private int data;
    private Node next; //利用引用类型储存地址，因为已经定义Node所以可以直接引用

    public Node(int data){
        this.data = data;
        this.next = null;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }


    public int getData() {
        return data;
    }
    public void setData(int data) {
        this.data = data;
    }
}
//组成单链表
 public class MyLineList {

    public Node head; //定义一个头节点
    public MyLineList(){
        this.head = null;       //设置头节点为空，也可以不设置
    }
    //打印单链表
    public void disPlay(){
        Node cur = this.head;
        while(cur!=null){
            System.out.print(cur.getData()+" ");
            cur = cur.getNext();
        }
    }
    //头插法
    public void addFirst(int data){
        Node node = new Node(data);
        if(this.head == null){
            //单链表中无节点
            this.head = node;
            return;
        }

        node.setNext(this.head);
        this.head = node;

    }
    //尾插法
    public void addLast(int data){
        Node node = new Node(data);
        if(this.head == null){
            //单链表中无节点
            this.head = node;
            return;
        }
        Node cur = this.head;
        while(cur.getNext()!=null){
            cur = cur.getNext();
        }
        //此时cur指向最后一个节点
        cur.setNext(node);
    }
    //在任意位置插入,第一个数据节点为0号下标
    public Node findIndex(int index){//找到prev
        int count = 0;
        Node cur = this.head;
        while (count < index-1){
            cur.setNext(cur.getNext());
            count++;
        }
        return cur;
    }
    public void addIndex(int index,int data){
        if(index<0||index>size()){
            throw new RuntimeException("输入位置不合法");
        }else if(index == 0){
            addFirst(data);
        }else if(index == size()){
            addLast(data);
        }else {
            Node node = new Node(data);
            Node prev = findIndex(data);
            node.setNext(prev.getNext());
            prev.setNext(node);
        }
    }
    public int size(){
        int count = 0;
        Node cur = this.head;
        while (cur!=null){
            count++;
            cur = cur.getNext();
        }
        return count;
    }
    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key){
        Node cur = this.head;
        while (cur!=null){
            if(cur.getData() == key){
                return true;
            }
            cur = cur.getNext();
        }
        return false;
    }
    //删除第一次出现关键字为key的节点
    private Node findPrev(int key){
        Node prev = this.head;
        while(prev.getNext()!=null){
            if(prev.getNext().getData() == key){
                return prev;
            }
            prev = prev.getNext();
        }
        return null;
    }
    public void remove(int key){
        if(this.head.getData() == key){
            this.head = this.head.getNext();
            return;
        }
        Node prev = findPrev(key);
        if(prev == null){
            System.out.println("没有这个节点！");
            return;
        }
        Node vel = prev.getNext();
        prev.setNext(vel.getNext());
    }
    //删除所有值为key的节点
    public void removeAllKey(int key){
        Node prev = this.head;
        Node cur = prev.getNext();
        while(cur!=null){
            if(cur.getData() == key){
                prev.setNext(cur.getNext());
            }else{
                prev = cur;

            }
            cur = cur.getNext();
        }
        if(this.head.getData() == key){
            this.head = this.head.getNext();
        }
    }
    //清空单链表
    public void clear(){
        this.head = null;/*
        while(this.head.getNext()!=null){
            Node del = this.head.getNext();
            this.head.setNext(del.getNext());
        }
        this.head = null;*/
    }

}
class Demo{
    public static void main(String[] args) {
        MyLineList myLineList = new MyLineList();
        myLineList.addLast(1);
        myLineList.addLast(2);
        myLineList.addLast(3);
        myLineList.addLast(3);
        myLineList.addLast(3);
        myLineList.addLast(6);
        myLineList.addLast(7);
        myLineList.addFirst(10);
        myLineList.addIndex(2,99);
        System.out.println("三种方法插入后结果：");
        myLineList.disPlay();
        System.out.println();
        System.out.println("单链表长度：");
        System.out.println(myLineList.size());
        System.out.println("查找是否存在10这个数据");
        System.out.println(myLineList.contains(10));
        System.out.println("删除单链表里面的数据10之后：");
        myLineList.remove(10);
        myLineList.disPlay();
        System.out.println();
        System.out.println("删除单链表里面所有的3之后：");
        myLineList.removeAllKey(3);
        myLineList.disPlay();
        System.out.println();
        System.out.println("清空单链表之后打印：");
        myLineList.clear();
        System.out.println();
        myLineList.disPlay();
    }
}
   /* public Node findKthToTail(int k) {
        if(k <= 0 || this.head==null) {
            return null;
        }
        Node fast = this.head;
        Node slow = this.head;
        //1、让fast先走k-1步
        for (int i = 0;i < k-1;i++){
            if(fast.getNext()!=null){
                fast = fast.getNext();
            }else {
                System.out.println("没有这个节点！");
            }
        }

        //2、让两个引用 一起走  直到 fast.next == null
        // slow 所指的位置就是倒数第K个节点
        while (fast.getNext()==null){
            fast = fast.getNext();
            slow = slow.getNext();
        }
        return slow;

    }*/