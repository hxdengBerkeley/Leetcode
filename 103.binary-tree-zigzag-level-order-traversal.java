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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Stack<TreeNode> level = new Stack<>();
        if (root!=null) {
            level.add(root);
            lOrver(result, level, false);
            result.remove(result.size() - 1);
        }
        return result;
    }

    public void lOrver(List<List<Integer>> result, Stack<TreeNode> level, boolean flag){
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
            if (flag){
                List<Integer> reverseresulti = new ArrayList<>();
                for (int i = resulti.size()-1; i >=0 ; i--) {
                    reverseresulti.add(resulti.get(i));
                }
                result.add(reverseresulti);
            }else {
                result.add(resulti);
            }
            lOrver(result,nextlevel,!flag);
        }
    }
}