/**
 * @Description:
 * @Author HuangZhuoLin
 * @Date 2020/3/28 8:45
 */
class Node{
    private int data;
    private Node next;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node(int data){
        this.data = data;
        this.next = null;
    }
}
 class SingleLineList {
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
    // 反转
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
    //返回中心节点
    public Node midnode(){
        Node fast = this.head;
        Node slow = this.head;
        while (fast != null && fast.getNext() != null){
            fast = fast.getNext().getNext();
            slow = slow.getNext();

        }
        return slow;
    }
    //输出倒数第K个节点
     public Node findnode(int k){
        if(this.head == null){
            return null;

        }
        Node fast = this.head;
        Node slow = this.head;
        if(k<0){
            return null;
        }
        for(int i = 0; i<k-1; i++){
           if(fast.getNext()!=null){
            fast = fast.getNext();
           }else {
               throw new RuntimeException("没有这个节点！");
           }
        }
        while (fast.getNext()!=null){
            fast = fast.getNext();
            slow = slow.getNext();
        }
        return slow;
     }
     //分割单链表
     public Node inTurn(int key){
        Node as = null;
        Node ae = null;
        Node bs = null;
        Node be = null;
        Node cur = this.head;
        while (cur!=null){
            if(cur.getData()<key){
                if(as == null){
                    as = cur;
                    ae = as;
                }else {
                    ae.setNext(cur);
                    ae = ae.getNext();
                }
            }else {
                if(bs == null){
                    bs = cur;
                    be = as;
                }else {
                    be.setNext(cur);
                    be = be.getNext();
                }
            }
            cur = cur.getNext();
        }
        if (as==null){
            return bs;
        }
        ae.setNext(bs);
        if(bs!=null){
            be.setNext(null);
        }

        return as;
     }
     public void display1(Node a) {
         Node cur = a;
         while (cur != null) {
             System.out.print(cur.getData() + " ");
             cur = cur.getNext();
         }
     }
     //在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，返回链表头指针。
     public Node removeRepeat(){
        Node node = new Node(0);
        Node cur = this.head;
        Node tmp = node;
        while (cur!=null){
            if(cur.getNext()!=null && cur.getData()==cur.getNext().getData()){
                while (cur.getNext()!=null && cur.getData()==cur.getNext().getData()){
                    cur = cur.getNext();
                }
                cur = cur.getNext();
            }else{
                tmp.setNext(cur);
                tmp = cur;
                cur = cur.getNext();
            }
        }
        tmp.setNext(null);
        return node.getNext();
     }
     //链表的回文结构
     public boolean HuiWen(){
        Node fast = this.head;
        Node slow = this.head;
        while (fast!=null && fast.getNext()!=null){
            fast = fast.getNext().getNext();
            slow = slow.getNext();
        }
        Node cur = slow.getNext();
        while (cur!=null){
            Node curNext = cur.getNext();
            cur.setNext(slow);
            slow = cur;
            cur = curNext;
        }
        while (slow != this.head){
            if(slow.getData()!=this.head.getData()){
                return false;
            }
            if(slow == this.head.getNext()){
                return true;
            }
            slow = slow.getNext();
            this.head = this.head.getNext();
        }
        return true;
     }
     //判断单链表是否有环
     public boolean hasCycle(){
        Node fast = this.head;
        Node slow = this.head;
        while (fast!=null && fast.getNext()!=null){
            fast = fast.getNext().getNext();
            slow = slow.getNext();
            if (fast == slow){
                break;
            }
        }
        if(fast == null||fast.getNext()==null){
            return false;
        }
        return true;
     }
     //找到环的入口
     public Node decletCycle(){
         Node fast = this.head;
         Node slow = this.head;
         while (fast!=null && fast.getNext()!=null){
             fast = fast.getNext().getNext();
             slow = slow.getNext();
             if (fast == slow){
                 break;
             }
         }
         if(fast == null||fast.getNext()==null){
             return null;
         }
         slow = this.head;
         while (slow!=fast){
             fast = fast.getNext();
             slow = slow.getNext();
     }
         return slow;
     }
}
public class LineListTest{
    public static void getNode(Node headA,Node headB ){
        headA.getNext().setNext(headB.getNext());
    }
    public static Node getIntersectionNode(Node headA,Node headB ){
        if(headA == null|| headB ==null){
            return null;
        }
        Node pl = headA;
        Node ps = headB;
        int lenA = 0;
        int lenB = 0;
        while (pl!=null){
            lenA++;
            pl=pl.getNext();
        }
        while (ps!=null){
            lenB++;
            ps=ps.getNext();
        }
        pl = headA;
        ps = headB;
        int len =lenA-lenB;
        if(len < 0){
            ps = headA;
            pl = headB;
            len = lenB-lenA;
        }
        while (len>0){
            pl = pl.getNext();
            len--;
        }
        while (pl != ps){
            pl = pl.getNext();
            ps = ps.getNext();
        }
        if(pl!=null && ps!=null && pl==ps){
            return pl;
        }
        return  null;

    }
    //输入两个链表，找出它们的第一个公共结点
    /*public Node findPublicNode(Node A,Node B){

    }*/
    public static  void main(String[] args) {
        SingleLineList singleLineList = new SingleLineList();
        SingleLineList singleLineList1 = new SingleLineList();
        singleLineList.addLastList(10);
        singleLineList.addLastList(20);
        singleLineList.addLastList(30);
        singleLineList.addLastList(20);
        singleLineList.addLastList(10);

        singleLineList1.addLastList(90);
        singleLineList1.addLastList(80);
        singleLineList1.addLastList(70);
        singleLineList1.addLastList(60);
        singleLineList1.addLastList(50);
        getNode(singleLineList.head,singleLineList1.head);
        Node ret = getIntersectionNode(singleLineList.head,singleLineList1.head);
        System.out.println(ret.getData());

    }
  }



