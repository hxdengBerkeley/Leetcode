/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head==null||head.next==null) return head;
        ListNode less = new ListNode(x), lessNode =less;
        ListNode greater = new ListNode(x), greaterNode = greater;
        ListNode now = head;
        while(now!=null){
            if (now.val<x){
                lessNode.next = now;
                lessNode=lessNode.next;
            }else {
                greaterNode.next=now;
                greaterNode=greaterNode.next;
            }
            now=now.next;
        }
        lessNode.next=greater.next;
        greaterNode.next=null;
        return less.next;
    }
}