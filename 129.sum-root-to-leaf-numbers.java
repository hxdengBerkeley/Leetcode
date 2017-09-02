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
    int result;
    public int sumNumbers(TreeNode root) {
        result = 0;
        if (root==null) return result;
        preOrder(root,0);
        return result;
    }
    public void preOrder(TreeNode root, int sumi){
        if (root==null) return;
        if (root.left==null&&root.right==null) {
            result+=sumi*10+root.val;
            return;
        }
        preOrder(root.left,sumi*10+root.val);
        preOrder(root.right,sumi*10+root.val);
    }
}