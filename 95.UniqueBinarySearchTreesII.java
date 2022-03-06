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
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> results = new ArrayList<>();
        if(n == 0){
            return results;
        }
        return helper(1, n);
    }
    
    private List<TreeNode> helper(int start, int end){
        List<TreeNode> results = new ArrayList<>();
        if(start > end){
            results.add(null);
            return results;
        }
        for(int i = start; i <= end; i++){
            List<TreeNode> leftNodes = helper(start, i - 1);
            List<TreeNode> rightNodes = helper(i + 1, end);
            for(TreeNode left : leftNodes){
                for(TreeNode right: rightNodes){
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    results.add(root);
                }
            }
        }
        return results;
    }
}
