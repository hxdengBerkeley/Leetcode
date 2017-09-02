/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root==null) return;
        else root.next=null;
        TreeLinkNode pre = root;
        TreeLinkNode head = null;
        TreeLinkNode now = null;
        while(pre!=null){
            while(pre!=null){
                if (pre.left!=null){
                    head = pre.left;
                    now = head;
                    break;
                }
                if (pre.right!=null) {
                    head = pre.right;
                    now = head;
                    break;
                }
                pre=pre.next;
            }
            while(pre!=null){
                if (pre.left!=null&&pre.left!=now){
                    now.next = pre.left;
                    now = now.next;
                }
                if (pre.right!=null&&pre.right!=now){
                    now.next = pre.right;
                    now = now.next;
                }
                pre=pre.next;
            }
            if (now!=null) now.next = null;
            pre = head;
            head = null;
        }
    }
}