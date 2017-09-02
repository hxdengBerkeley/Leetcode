/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
	public ListNode deleteDuplicates(ListNode head) {
		if (head==null||head.next==null) return head;
		if (head.next.next==null){
			if (head.val==head.next.val) return null;
			else return head;
		}
		ListNode a = head , b = a.next, c = b.next;
		while(c.next!=null){
			if (a.val==b.val&&b.val==c.val){
				a.next=c;
				b=c;
				c=c.next;
			}else {
				a=b;
				b=c;
				c=c.next;
			}
		}
		if (a.val==b.val&&b.val==c.val) {
			b.next=null;
		}
		ListNode result = new ListNode(-10);
		a=result;
		a.next=head;
		while(a.next!=null&&a.next.next!=null){
			if (a.next.val==a.next.next.val){
				a.next=a.next.next.next;
			}else{
				a=a.next;
			}
		}
		return result.next;
	}
}
