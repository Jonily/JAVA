// 本题为考试单行多行输入输出规范示例，无需提交，不计分。
import java.util.*;

public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
 class Partition {
    public ListNode partition(ListNode pHead, int x) {
        if(pHead == null){
            return pHead;
        }
        ListNode A = new ListNode(0);
        ListNode Apre = A;
        ListNode B = new ListNode(0);
        ListNode Bpre = B;
        ListNode pre = pHead;
        while(pre != null){
            if(pre.val < x ){
                A.next = pre;
                A = A.next;
            }else {
                B.next = pre;
                B = B.next;
            }
            pre = pre.next;
        }
        A.next = Bpre.next;
        B.next = null;
        return Apre.next;
    }
}