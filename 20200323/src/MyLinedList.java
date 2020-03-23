/**
 * @Description:
 * @Author HuangZhuoLin
 * @Date 2020/3/23 18:58
 */
//节点类
class Node{
    public int data;
    public Node next;//不进行初始化 作为引用类型拿到Node地址，可以存放地址

    public Node(int data){
        this.data = data;
    }
}
//单链表（由节点构成单链表）
public class MyLinedList {
    public Node head;
    public MyLinedList(){
        this.head = null;
    }
    //头插法
    public void addFirst(int data){
      Node node = new Node(data);//拿到节点
        if(this.head == null){
            //第一次插入节点
            this.head = node;
            return;
        }
      node.next = this.head; //把链表原来的头给新节点的next
      this.head = node;//让新节点成为新的头
    }
    //尾插法
    public void addLast(int data){
        Node node = new Node(data);
        if(this.head == null){
            //第一次插入节点
            this.head = node;
            return;
        }
        Node cur = this.head;
        while(cur.next!=null){
         cur = cur.next;
        }
        cur.next = node;
    }
    //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index,int data){
        if(index<0||index>size()){
            throw new RuntimeException("index位置不合法！");
        }
        if(index==0){
            addFirst(data);
            return;
        }
        if(index == size()){
            addLast(data);
            return;
        }
        Node prev = findIndex(index);
        Node node = new Node(data);
        node.next = prev.next;
        prev.next = node;

    }
    private Node findIndex(int index){
        Node prev = this.head;
        int count = 0 ;
        while (count < index-1){
            prev = prev.next;
            count++;
        }
        return prev;
    }
    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key){
        Node cur = this.head;
        while(cur!=null){
          if(cur.data == key){
             return true;
            }
            cur = cur.next;
         }
        return false;
    }
    private Node findPrev(int key){
        Node prev = this.head;
        while(prev.next!= null){
            if(prev.next.data == key){
                System.out.println("找到节点！");
                return prev;
            }
            prev = prev.next;
        }
        return null;
    }
    //删除第一次出现关键字为key的节点
    public void remove(int key){
        if(this.head.data == key){
            this.head = this.head.next;
        }
        Node prev = findPrev(key);
            if(prev == null){
                System.out.println("没有要删除的节点！");
                return ;
            }
        Node del = prev.next;
        prev.next = del.next;
        }

    //删除所有值为key的节点
    public void removeAllKey(int key){


    }
    //得到单链表的长度
    public int size(){
        int count = 0 ;
        Node cur = this.head;
        while(cur!=null){
            count++;
            cur = cur.next;
        }
        return count;
    }
//打印单链表
    public void display(){
        Node cur = this.head;
        while (cur!= null){
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
    }
    public void clear(){

    }
}
class Demo{
    public static void main(String[] args) {
        MyLinedList myLinedList = new MyLinedList();
        myLinedList.addLast(1);
        myLinedList.addLast(2);
        myLinedList.addFirst(5);
        myLinedList.display();
        boolean flag = myLinedList.contains(5);
        System.out.println(flag);
        myLinedList.size();
        myLinedList.remove(2);
        myLinedList.display();


    }
}