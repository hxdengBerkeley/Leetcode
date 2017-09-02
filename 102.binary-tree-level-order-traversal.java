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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Stack<TreeNode> level = new Stack<>();
        if (root!=null) {
            level.add(root);
            lOrver(result, level);
            result.remove(result.size() - 1);
        }
        return result;
    }

    public void lOrver(List<List<Integer>> result, Stack<TreeNode> level){
        if (level.size()==0) return;
        else {
            Stack<TreeNode> nextlevel = new Stack<>();
            List<Integer> resulti = new ArrayList<>();
            for (TreeNode root:level) {
                if (root!=null){
                    resulti.add(root.val);
                    nextlevel.add(root.left);
                    nextlevel.add(root.right);
                }
            }
            result.add(resulti);
            lOrver(result,nextlevel);
        }
    }
}