package 求两个链表和;
import java.util.*;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class Plus {
    public ListNode plusAB(ListNode a, ListNode b) {
        if(a == null){
            return b;
        }
        if(b == null){
            return a;
        }

        ListNode p1 = a;
        ListNode p2 = b;
        ListNode Node = new ListNode(0);
        ListNode head = Node;
        int sum = 0;
        while (p1 != null || p2 !=null || sum != 0){
            if(p1 != null){
                sum += p1.val;
                p1 = p1.next;
            }
            if(p2 != null){
                sum += p2.val;
                p2 = p2.next;
            }
            head.next = new ListNode(sum % 10);
            sum /= 10;
            head = head.next;
        }
        return Node.next;
    }
}