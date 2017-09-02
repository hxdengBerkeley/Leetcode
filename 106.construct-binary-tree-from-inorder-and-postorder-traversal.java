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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildBST(postorder,inorder,postorder.length-1,0,inorder.length-1);
    }

    public TreeNode buildBST(int[] postorder, int[] inorder, int postindex, int instart, int inend ){
        if (postindex<0||inend<instart) return null;
        TreeNode root = new TreeNode(postorder[postindex]);
        for (int rootindex = instart; rootindex <= inend; rootindex++) {
            if (inorder[rootindex]==root.val){
                root.left = buildBST(postorder,inorder,postindex-inend+rootindex-1, instart, rootindex-1);
                root.right = buildBST(postorder,inorder,postindex-1,rootindex+1,inend);
            }
        }
        return root;
    }
}