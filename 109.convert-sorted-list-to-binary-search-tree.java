/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        return list2BST(head,null);
    }

    public TreeNode list2BST(ListNode head, ListNode tail){
        if (head==null||head==tail) return null;
        ListNode fast = head, slow = head;
        while (fast!=tail&&fast.next!=tail){
            fast=fast.next.next;
            slow=slow.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = list2BST(head,slow);
        root.right = list2BST(slow.next,tail);
        return root;
    }
}