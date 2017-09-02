/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        if (head==null||head.next==null) return;
        ListNode slow=head,fast=head;
        while(fast.next!=null&&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        if (slow==fast) return;

        //1-2-3-4-5-6-null >> 1-2-3-6-5-4-null;
        ListNode a = slow.next, b = a.next, c = b==null?null:b.next;
        a.next = null;
        while (c != null) {
            b.next = a;
            a = b;
            b = c;
            c = c.next;
        }
        if (b!=null) {
            b.next = a;
            slow.next = b;
        }

        //1-2-3-6-5-4-null >> 1-6-2-5-3-4-null;
        ListNode A=head,B=A.next,C=slow.next,D=C.next;
        while(B!=slow.next){
            A.next=C;
            C.next=B;
            A=B;
            B=B.next;
            C=D;
            if (D==null) break;
            D=D.next;
        }
        A.next=C;
    }
}