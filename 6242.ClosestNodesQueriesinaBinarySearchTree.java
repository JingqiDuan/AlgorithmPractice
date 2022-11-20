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
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        TreeSet<Integer> set = new TreeSet<>();
        List<List<Integer>> results = new ArrayList<>();
        helper(root, set);
        for(int val : queries){
            int min = set.floor(val) == null ? -1 : set.floor(val);
            int max = set.ceiling(val) == null ? -1 : set.ceiling(val);
            ArrayList<Integer> subset = new ArrayList<>();
            subset.add(min);
            subset.add(max);
            results.add(subset);
        }
        return results;
    }
    public void helper(TreeNode root, TreeSet<Integer> set){
        if(root == null) return;
        set.add(root.val);
        helper(root.left, set);
        helper(root.right, set);
    }
}
