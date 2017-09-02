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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> resulti = new ArrayList<>();
        pathSum2(result,resulti,root,sum);
        return result;
    }

    public void pathSum2(List<List<Integer>> result, List<Integer> resulti, TreeNode root, int sum){
        if (root==null) return;
        else {
            if (sum==root.val&&root.left==null&&root.right==null) {
                List<Integer> resulticpy = new ArrayList<>(resulti);
                resulticpy.add(root.val);
                result.add(resulticpy);
            } else {
                List<Integer> resulticpy1 = new ArrayList<>(resulti);
                List<Integer> resulticpy2 = new ArrayList<>(resulti);
                resulticpy1.add(root.val);
                resulticpy2.add(root.val);
                pathSum2(result,resulticpy1,root.left,sum-root.val);
                pathSum2(result,resulticpy1,root.right,sum-root.val);
            }
        }
    }
}
