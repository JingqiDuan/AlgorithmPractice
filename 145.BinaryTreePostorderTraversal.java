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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        helper(root, results);
        return results;
    }
    
    private void helper(TreeNode root, List<Integer> results){//postorder: left, right, root
        if(root == null){
            return;
        }
        helper(root.left, results);//all the way left
        helper(root.right, results);//all the way right
        results.add(root.val);//always add root
    }
}
