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
    int Max;

    public int maxPathSum(TreeNode root) {
        Max = Integer.MIN_VALUE;
        maxSum(root);
        return Max;
    }

    public int maxSum(TreeNode root){
        if (root==null) return 0;
        int left = Math.max(0,maxSum(root.left));
        int right = Math.max(0,maxSum(root.right));
        Max = Math.max(Max,left+right+root.val);
        return Math.max(left,right)+root.val;
    }
}