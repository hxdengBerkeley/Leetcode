/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null) return null;
        ListNode node = head;
        int length=1;
        while(node.next!=null){
            node=node.next;
            length++;
        }
        k=k%length;
        node.next=head;
        int i=length-k;
        node=head;
        while(i>1){
            i--;
            node=node.next;
        }
        ListNode result = node.next;
        node.next = null;
        return result;
    }
}
