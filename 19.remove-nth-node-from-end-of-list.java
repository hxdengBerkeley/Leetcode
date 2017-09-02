/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
    	ListNode before = head, end = head;
	if(head.next==null) return null;
	while(n>0){
		end = end.next;
		n--;
	}
	if(end==null){
		return head.next;
	}else{
		while(end.next!=null){
			end = end.next;
			before = before.next;
		}
		before.next = before.next.next;
		return head;
	}
    }
}
