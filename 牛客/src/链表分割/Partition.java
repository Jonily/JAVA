package 链表分割;
import java.util.*;


 class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class Partition {
    public ListNode partition(ListNode pHead, int x) {
        if(pHead == null){
            return pHead;
        }
        ListNode small = new ListNode(0);
        ListNode big = new ListNode(-1);
        //分别设置头指针指向两个链表的首节点
      ListNode sHead = small;
      ListNode bHead = big;
        ListNode cur = pHead;
        while (cur != null){
            if(cur.val < x){
                small.next = cur;
                small = small.next;
            }else {
                big.next = cur;
                big = big.next;
            }
            cur = cur.next;
        }

        //small链表最后一个节点指向big的头指针，即bigHead
        small.next = bHead.next;
        //big链表最后一个节点设置为尾节点，即设置为null
        big.next = null;
        return sHead.next;
    }
}