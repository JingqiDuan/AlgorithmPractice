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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        //store each sum of the node to root to a queue
        Queue<Integer> queueVal = new LinkedList<>();
        queue.offer(root);
        queueVal.offer(root.val);
        while(!queue.isEmpty()){
            TreeNode head = queue.poll();
            int sumToNode = queueVal.poll();
            if(head.left == null && head.right == null){
                if(sumToNode == targetSum){
                    return true;
                }
            }
            if(head.left != null){
                queue.offer(head.left);
                queueVal.offer(sumToNode + head.left.val);
            }
            if(head.right != null){
                queue.offer(head.right);
                queueVal.offer(sumToNode + head.right.val);
            }
        }
        return false;
    }
}
