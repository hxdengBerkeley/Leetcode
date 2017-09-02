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
    TreeNode first = null, second=null;
    TreeNode pre = new TreeNode(Integer.MIN_VALUE);

    public void recoverTree(TreeNode root) {
        traverse(root);
        if (first!=null&&second!=null){
            int temp = first.val;
            first.val=second.val;
            second.val=temp;
        }
    }
    public void traverse(TreeNode root){
        if (root==null) return;
        traverse(root.left);
        if (root.val<pre.val){
            if (first==null){
                first=pre;
                second=root;
            }else {
                second=root;
                return;
            }
        }
        pre=root;
        traverse(root.right);
    }
}