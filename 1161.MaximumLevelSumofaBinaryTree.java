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
    public int maxLevelSum(TreeNode root) {
        if(root == null){
            return 0;
        }
        int maxSum = root.val;
        int levelOfMax = 1;
        int curLevel = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            int levelSum = 0;
            for(int i = 0; i < size; i++){
                TreeNode head = queue.poll();
                if(head.left != null){
                    queue.offer(head.left);
                    levelSum += head.left.val;
                }
                if(head.right != null){
                    queue.offer(head.right);
                    levelSum += head.right.val;
                }
            }
            curLevel++;
            if(queue.isEmpty()) break;
            if(levelSum > maxSum){
                maxSum = levelSum;
                levelOfMax = curLevel;
            }
        }
        return levelOfMax;
    }
}
