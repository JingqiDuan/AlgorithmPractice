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
    public int longestConsecutive(TreeNode root) {
        return helper(root, null, 0);
    }

    public int helper(TreeNode current, TreeNode parent, int length){
        if(current == null){
            return length;
        }
        length = parent != null && current.val == parent.val + 1 ? length + 1 : 1;
        return Math.max(length, Math.max(helper(current.left, current, length), helper(current.right, current, length)));
    }
}
