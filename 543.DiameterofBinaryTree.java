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
    private int maxValue = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return maxValue;
    }

    public int helper(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftGain = helper(root.left);
        int rightGain = helper(root.right);
        int pathGain = leftGain + rightGain;
        maxValue = Math.max(maxValue, pathGain);
        return 1 + Math.max(leftGain, rightGain);
    }
}
