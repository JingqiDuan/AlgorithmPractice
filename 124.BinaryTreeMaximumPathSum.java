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
    private int maxValue = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return maxValue;
    }
    public int helper(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftGain = Math.max(helper(root.left), 0);
        int rightGain = Math.max(helper(root.right), 0);
        //every mininal unit as path
        int pathGain = root.val + leftGain + rightGain;
        maxValue = Math.max(maxValue, pathGain);
        //because it's a path
        return root.val + Math.max(leftGain, rightGain);
    }
}
