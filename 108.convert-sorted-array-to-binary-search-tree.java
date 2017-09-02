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
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length==0) return null;
        return array2BST(nums,0,nums.length-1);
    }
    public TreeNode array2BST(int[] nums, int start, int end){
        if (start>end) return null;
        else {
            TreeNode root = new TreeNode(nums[(start+end+1)/2]);
            root.left = array2BST(nums,start,(start+end+1)/2-1);
            root.right = array2BST(nums,(start+end+1)/2+1, end);
            return root;
        }
    }
}