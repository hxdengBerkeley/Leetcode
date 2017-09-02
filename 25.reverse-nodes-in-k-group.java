/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
	if( head==null || head.next == null ) return head;
	ListNode result = new ListNode(1); result.next = head;
	ListNode end=result;
	
	do{
		end = reverseK(end, end.next, k);
	}while(end!=null);
	return result.next;
    }

	public ListNode reverseK(ListNode end, ListNode head, int k){
		if(size(head)<k) return null;
		ListNode node=head,nexthead;
		for(int j=1; j<k; j++){
			node=node.next;
		}
		end.next = node; end = end.next;
		nexthead = node.next;
		for(int i=k-1; i>0; i--){
			node = head;
			for(int j=1; j<i; j++){
				node = node.next;
			}
			end.next = node;
			end = end.next;
		}
		head.next = nexthead;
		return head;			
	}

	public int size(ListNode head){
		if(head==null) return 0;
		return size(head.next)+1;
	}
}
