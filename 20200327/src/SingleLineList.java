/**
 * @Description: 单链表
 * @Author HuangZhuoLin
 * @Date 2020/3/27 11:41
 */
class Node{


    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    private int data;

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    private Node next;
    public Node(int data){
        this.data = data;
        this.next = null;
    }
}
public class SingleLineList {
    public Node head;
    public SingleLineList(){
        this.head = null;
    }
    public void display(){
        Node cur = this.head;
        while (cur!=null){
            System.out.print(cur.getData()+" ");
            cur = cur.getNext();
        }
    }
    public void addHeadList(int data){
        Node node = new Node(data);
        node.setNext(this.head);
        this.head = node;
    }
    public void addLastList(int data){
        Node node = new Node(data);
        if(this.head == null){
            this.head = node;
            return;
        }
        Node cur = this.head;
        while(cur.getNext()!=null){
            cur = cur.getNext();
        }
        cur.setNext(node);
    }
    public int size(){
        int count = 0;
        Node cur = this.head;
        while(cur!=null){
            count++;
            cur = cur.getNext();
        }
        return count;
    }
    public Node findIndex(int index){
        Node prev = this.head;
        for(int i = 0;i<index-1;i++){
            prev = prev.getNext();
        }
        return prev;
    }
    public void addIndex(int index,int data){
        if(index<0 || index>size()){
            throw new RuntimeException("插入位置不合法！");
        }
        Node cur = findIndex(index);
        Node node = new Node(data);
        node.setNext(cur.getNext());
        cur.setNext(node);
    }
    public boolean contain(int key){
        Node cur = this.head;
        while (cur!=null){
            if(cur.getData() == key){
                return true;
            }
            cur = cur.getNext();
        }
        return false;
    }
    public Node findPrev (int key){
        Node prev = this.head;
        while (prev.getNext().getData() != key){
            prev = prev.getNext();
        }
        return prev;
    }
    public void remove(int key){
        Node prev = findPrev(key);
        Node cur = prev.getNext();
        prev.setNext(cur.getNext());
    }
    public void removeAllkey(int key){
        Node prev = this.head;
        Node cur = this.head.getNext();
        while (cur!=null){
            if(cur.getData()==key){
                prev.setNext(cur.getNext());
            }else{

                prev = cur;
            }
            cur = cur.getNext();
        }
        if (this.head.getData()==key){
            this.head = this.head.getNext();
        }
    }
    public void clear(){
        this.head = null;
    }
    public void turnRround(){
        Node cur = this.head;

        Node prev = null;
        while (cur != null){
            Node vel = cur.getNext();
            if(vel == null){
                this.head = cur;
            }
            cur.setNext(prev);
            prev = cur;
            cur = vel;

        }
    }

}
class Test{
    public static void main(String[] args) {
        SingleLineList singleLineList = new SingleLineList();
        singleLineList.addHeadList(10);
        singleLineList.addLastList(20);
        singleLineList.addLastList(30);
        singleLineList.addLastList(100);
        singleLineList.addLastList(100);
        singleLineList.addLastList(100);
        singleLineList.addIndex(2,60);
        singleLineList.display();
        System.out.println();
        System.out.println(singleLineList.contain(60));
        singleLineList.remove(60);
        System.out.println(singleLineList.contain(60));
        singleLineList.display();
        System.out.println();
        singleLineList.removeAllkey(100);
        singleLineList.display();
        System.out.println("=============");
        singleLineList.turnRround();

        //singleLineList.clear();
        singleLineList.display();


    }

}
