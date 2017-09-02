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
    public boolean isSymmetric(TreeNode root) {
        if (root==null) return true;
        else return traverse(root.left,root.right);
    }

    public boolean traverse(TreeNode left, TreeNode right){
        if (left==null&&right==null) return true;
        else if (left!=null&&right!=null&&left.val==right.val) return traverse(left.left,right.right)&&traverse(left.right,right.left);
        else return false;
    }
}