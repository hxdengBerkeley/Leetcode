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
        connectAB(root,null);
    }
    public void connectAB(TreeLinkNode A, TreeLinkNode B){
        if (A==null) return;
        A.next = B;
        connectAB(A.left,A.right);
        if (B==null){
            connectAB(A.right,null);
        }else {
            connectAB(A.right,B.left);
            connectAB(B.left,B.right);
            connectAB(B.right,null);
        }
    }
}