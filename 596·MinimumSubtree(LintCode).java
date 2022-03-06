/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param root: the root of binary tree
     * @return: the root of the minimum subtree
     */

    public class ResultType{
        private TreeNode minSubtree;
        private int minSum, sum;
        public ResultType(TreeNode minSubtree, int minSum, int sum){
            this.minSubtree = minSubtree;
            this.minSum = minSum;
            this.sum = sum;
        }
    }

    public TreeNode findSubtree(TreeNode root) {
        // write your code here
        ResultType result = helper(root);
        return result.minSubtree;
    }

    private ResultType helper(TreeNode root){
        if(root == null){
            return new ResultType(null, Integer.MAX_VALUE, 0);
        }
        ResultType leftResult = helper(root.left);
        ResultType rightResult = helper(root.right);
        TreeNode minSubTree = root;
        int minSum = leftResult.sum + rightResult.sum + root.val;
        int sum = minSum;
        if(leftResult.minSum <= minSum){
            minSubTree = leftResult.minSubtree;
            minSum = leftResult.minSum;
        }
        if(rightResult.minSum <= minSum){
            minSubTree = rightResult.minSubtree;
            minSum = rightResult.minSum;
        }
        return new ResultType(minSubTree, minSum, sum);
    }    
}
