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
    int result;
    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        helper(root, 0, map, targetSum);
        return result;
    }

    public void helper(TreeNode root, int accumulativeSum, HashMap<Integer, Integer> map, int targetSum){
        if(root == null){
            return;
        }
        accumulativeSum += root.val;
        //check first then update in map
        result += map.getOrDefault(accumulativeSum - targetSum, 0);
        map.put(accumulativeSum, map.getOrDefault(accumulativeSum, 0) + 1);
        helper(root.left, accumulativeSum, map, targetSum);
        helper(root.right, accumulativeSum, map, targetSum);
        map.put(accumulativeSum, map.getOrDefault(accumulativeSum, 1) - 1);
    }
}
