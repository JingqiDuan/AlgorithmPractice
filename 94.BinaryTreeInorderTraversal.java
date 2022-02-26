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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        helper(root, results);
        return results;
    }
    private void helper(TreeNode root, List<Integer> results){
        if(root == null){ //define the end condition of recursion
            return;
        }
        helper(root.left, results);//let's say helper add the node to results
        results.add(root.val);
        helper(root.right, results);
    }
}
