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
    
    public int closestValue(TreeNode root, double target) {
        TreeNode lowerBound = root;
        TreeNode upperBound = root;
        while(root != null){
            if(target < root.val){
                upperBound = root;
                root = root.left;
            }else if(target > root.val){
                lowerBound = root;
                root = root.right;
            }else{
                return root.val;
            }
        }
        boolean isUppperCase = Math.abs(upperBound.val - target) <= Math.abs(target - lowerBound.val);
        return isUppperCase ? upperBound.val : lowerBound.val;
    }
}
