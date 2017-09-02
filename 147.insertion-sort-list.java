/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head==null) return null;
        ListNode result = new ListNode(Integer.MIN_VALUE);
        ListNode now=result,next;
        while (head!=null){
            now = result;
            next=head.next;
            while(now!=null&&now.next!=null&&!(now.val<=head.val&&now.next.val>=head.val)){
                now=now.next;
            }
            head.next=now.next;
            now.next=head;
            head=next;
        }
        return result.next;
    }
}