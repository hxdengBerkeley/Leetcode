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
    public boolean isValidBST(TreeNode root) {
        return vBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean vBST(TreeNode root, long min, long max){
        if (root==null) return true;
        boolean left = root.left==null||(root.left.val>min&&root.left.val<root.val&&vBST(root.left,min,root.val));
        boolean right = root.right==null||(root.right.val<max&&root.right.val>root.val&&vBST(root.right,root.val,max));
        return left&&right;
    }
}