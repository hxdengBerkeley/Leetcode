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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildBST(preorder,inorder,0,0,inorder.length-1);
    }

    public TreeNode buildBST(int[] preorder, int[] inorder, int preindex, int instart, int inend ){
        if (preindex>=preorder.length||inend<instart) return null;
        TreeNode root = new TreeNode(preorder[preindex]);
        for (int rootindex = instart; rootindex <= inend; rootindex++) {
            if (inorder[rootindex]==root.val){
                root.left = buildBST(preorder,inorder,preindex+1, instart, rootindex-1);
                root.right = buildBST(preorder,inorder,preindex+1+rootindex-instart,rootindex+1,inend);
            }
        }
        return root;
    }
}