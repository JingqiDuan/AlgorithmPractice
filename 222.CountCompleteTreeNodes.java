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
    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        int depthLeft = 1;
        TreeNode leftNode = root.left;
        while(leftNode != null){
            depthLeft++;
            leftNode = leftNode.left;
        }
        TreeNode rightNode = root.right;
        int depthRight = 1;
        while(rightNode != null){
            depthRight++;
            rightNode = rightNode.right;
        }
        if(depthLeft == depthRight){
            return (int) Math.pow(2, depthLeft) - 1;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
