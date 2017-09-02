/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        if (head==null||head.next==null) return head;
        ListNode slow=head,fast=head;
        while(fast!=null&&fast.next!=null&&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode l1 = head, l2 = slow.next;
        slow.next = null;
        return merge(l1,l2);
    }

    public ListNode merge(ListNode l1, ListNode l2){
        l1 = sortList(l1);
        l2 = sortList(l2);
        ListNode result = new ListNode(Integer.MIN_VALUE),now=result;
        while(l1!=null&&l2!=null){
            if (l1.val<l2.val){
                now.next=l1;
                l1=l1.next;
            }else {
                now.next=l2;
                l2=l2.next;
            }
            now=now.next;
        }
        if (l1==null){
            now.next=l2;
        }else {
            now.next=l1;
        }
        return result.next;
    }
}