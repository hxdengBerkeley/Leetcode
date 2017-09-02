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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode now = root;
        while(now!=null||!stack.isEmpty()) {
            while(now!=null){
                stack.push(now);
                now=now.left;
            }
            now = stack.pop();
            result.add(now.val);
            now = now.right;
        }
        return result;
    }

    /**Recursive
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inOrder(result,root);
        return result;
    }

    public void inOrder(List<Integer> result, TreeNode root){
        if (root==null) return;
        inOrder(result,root.left);
        result.add(root.val);
        inOrder(result,root.right);
    }*/
}