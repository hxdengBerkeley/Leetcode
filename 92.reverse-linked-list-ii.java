/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m==n) return head;
        ListNode fakeHead = new ListNode(0);
        fakeHead.next=head;
        ListNode x = fakeHead;
        for (int i = 1; i < m; i++) {
            x=x.next;
        }
        ListNode y = x.next;
        ListNode pre = y, mid = pre.next, then = mid.next;
        mid.next=pre;
        for (int i = 1; i < n-m; i++) {
            pre = mid;
            mid = then;
            then=then.next;
            mid.next = pre;
        }
        x.next=mid;
        y.next=then;
        return fakeHead.next;
    }
}