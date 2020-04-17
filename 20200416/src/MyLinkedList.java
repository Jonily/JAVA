/**
 * @Description:
 * @Author HuangZhuoLin
 * @Date 2020/4/16 21:55
 */

public class MyLinkedList {

    class Node {
        public int val;
        public Node next;
        public Node(int val) {
            this.val = val;
        }
    }

    int length;
    Node head;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        length = 0;
        head = null;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index >= length|| index < 0){
            return -1;
        }
        Node cur = head;
        for (int i = 0; i <index;i++){
            cur = cur.next;
        }
        return cur.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node cur = new Node(val);
        cur.next = head;
        head = cur;
        length++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node cur = new Node(val);
        Node prev = head;
        if(head.next==null){
            head.next = cur;
        }
        while (cur.next!=null){
            prev = prev.next;
        }
        prev.next = cur;
        length++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index > length){
            return;
        }
        if(index ==0){
            addAtHead(val);
        }
        if(index == length){
            addAtTail(val);
        }
        Node cur = new Node(val);
        Node prev = head;

        for(int i = 0;i < index;i++){
            prev = prev.next;
        }
        cur.next = prev.next;
        prev.next = cur;
        length++;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index >= length|| index < 0){
            return;
        }
        Node cur = head;
        for(int i = 0;i < index;i++){
            cur = cur.next;
        }
        cur.next = cur.next.next;
        length--;
    }
}
