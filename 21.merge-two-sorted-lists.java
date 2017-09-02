/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
	if(l1==null) return l2;
	if(l2==null) return l1;
	ListNode result,end;
	if(l1.val<l2.val){
		result = l1;
		l1 = l1.next;
	}else{
		result = l2;
		l2 = l2.next;
	}
	end = result;
	while(l1!=null&&l2!=null){
		if(l1.val<l2.val){
			end.next = l1;
			l1=l1.next;
		}else{
			end.next = l2;
			l2=l2.next;
		}
		end = end.next;
	}
	if(l1==null) end.next = l2;
	if(l2==null) end.next = l1;
	return result;  
    }
}
