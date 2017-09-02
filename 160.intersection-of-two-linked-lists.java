/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode now = headA;
        int length1 = 0;
        while(now!=null){
            now=now.next;
            length1++;
        }

        now = headB;
        int length2 = 0;
        while(now!=null){
            now=now.next;
            length2++;
        }
        ListNode nowA=headA,nowB=headB;
        if (length1<length2){
            for (int i = 0; i < length2-length1; i++) {
                nowB = nowB.next;
            }
        }else {
            for (int i = 0; i < length1-length2; i++) {
                nowA = nowA.next;
            }
        }

        while (nowA!=null&&nowB!=null){
            if (nowA==nowB) return nowA;
            else {
                nowA=nowA.next;
                nowB=nowB.next;
            }
        }
        return null;
    }
}