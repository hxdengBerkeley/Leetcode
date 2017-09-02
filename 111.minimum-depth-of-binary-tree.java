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
    public int minDepth(TreeNode root) {
        if(root==null) return 0;
        Stack<TreeNode> level = new Stack<>();
        level.add(root);
        return lOrver(level);
    }
    public int lOrver(Stack<TreeNode> level){
        if (level.size()==0) return 0;
        else {
            Stack<TreeNode> nextlevel = new Stack<>();
            for (TreeNode root:level) {
                if (root!=null){
                    if (root.left==null&&root.right==null) return 1;
                    nextlevel.add(root.left);
                    nextlevel.add(root.right);
                }
            }
            return lOrver(nextlevel)+1;
        }
    }
}