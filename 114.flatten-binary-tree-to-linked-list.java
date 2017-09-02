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
    public void flatten(TreeNode root) {
        if (root==null) return;
        List<Integer> values = new ArrayList<>();
        preOrder(values,root);
        TreeNode result = new TreeNode(root.val);
        TreeNode now = root;
        for (int i = 1; i < values.size(); i++) {
            now.left = null;
            now.right = new TreeNode(values.get(i));
            now = now.right;
        }
    }

    public void preOrder( List<Integer> values, TreeNode root){
        if (root!=null){
            values.add(root.val);
            preOrder(values,root.left);
            preOrder(values,root.right);
        }
    }
}