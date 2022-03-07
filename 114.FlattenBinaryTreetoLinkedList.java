/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void flatten(TreeNode root) {
        flatternAndReturnLastNode(root);
    }

    private TreeNode flatternAndReturnLastNode(TreeNode root){
        if(root == null){
            return null;
        }
        TreeNode lastLeft = flatternAndReturnLastNode(root.left);
        TreeNode lastRight = flatternAndReturnLastNode(root.right);
        if(root.left != null){//root.left
            lastLeft.right = root.right;
            root.right = root.left;//root point to first left
            root.left = null;
        }
        if(lastRight != null){
            return lastRight;
        }else if(lastLeft != null){
            return lastLeft;
        }
            return root;
    }
}
