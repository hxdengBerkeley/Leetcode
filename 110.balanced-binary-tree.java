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
    public boolean isBalanced(TreeNode root) {
        if (root==null) return true;
        else {
            return Math.abs(maxDepth(root.left)-maxDepth(root.right))<=1&&isBalanced(root.left)&&isBalanced(root.right);
        }
    }
    public int maxDepth(TreeNode root) {
        if (root!=null) {
            Stack<TreeNode> level = new Stack<>();
            level.add(root);
            return lOrver(level)-1;
        }else return 0;
    }
    public int lOrver(Stack<TreeNode> level){
        if (level.size()==0) return 0;
        else {
            Stack<TreeNode> nextlevel = new Stack<>();
            for (TreeNode root:level) {
                if (root!=null){
                    nextlevel.add(root.left);
                    nextlevel.add(root.right);
                }
            }
            return lOrver(nextlevel)+1;
        }
    }
}