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
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root == null){
            return result;
        }
        TreeNode prev = null;
        while(root != null || !stack.empty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            //back track
            root = stack.pop();
            if(root.right == null || root.right == prev){//border case, the last right one
                result.add(root.val);
                prev = root;
                root = null;
            }else{
                stack.push(root);
                root = root.right;
            }
        }
        return result;
    }
}
