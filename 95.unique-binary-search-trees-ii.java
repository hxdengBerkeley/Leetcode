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
    public List<TreeNode> generateTrees(int n) {
        if (n==0) return new ArrayList<TreeNode>();
        return genBST(1,n);
    }

    public List<TreeNode> genBST(int start, int end){
        List<TreeNode> result = new ArrayList<>();
        if (start>end) {
            result.add(null);
        }else if (start==end){
            TreeNode root = new TreeNode(start);
            result.add(root);
        }else {
            for (int i = start; i <= end ; i++) {
                List<TreeNode> left,right;
                left = genBST(start,i-1);
                right = genBST(i+1,end);
                for (int j = 0; j < left.size(); j++) {
                    for (int k = 0; k < right.size(); k++) {
                        TreeNode root = new TreeNode(i);
                        root.left = left.get(j);
                        root.right = right.get(k);
                        result.add(root);
                    }
                }
            }
        }
        return result;
    }
}