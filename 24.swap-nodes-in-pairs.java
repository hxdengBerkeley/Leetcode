/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
	if(head==null||head.next==null) return head;
	ListNode result = head.next;  // first step
	head.next = result.next;
	result.next = head;
	while(swapNextPairs(head,head.next)){
		head = head.next.next;
	}
	return result;	        
    }
	public boolean swapNextPairs(ListNode end, ListNode head){
		if(head==null||head.next==null) return false;
		end.next = head.next;
		head.next = head.next.next;
		end.next.next = head;
		return true;		
	}
}
