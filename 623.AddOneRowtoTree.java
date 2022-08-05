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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1){
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }
        int level = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            level++;
            for(int i = 0; i < size; i++){
                TreeNode head = queue.poll();
                if(depth == level){
                    TreeNode tmpLeft = head.left;
                    TreeNode tmpRight = head.right;
                    TreeNode newLeft = new TreeNode(val);
                    TreeNode newRight = new TreeNode(val);
                    head.left = newLeft;
                    head.right = newRight;
                    newLeft.left = tmpLeft;
                    newRight.right = tmpRight;
                }else{
                    if(head.left != null){
                        queue.offer(head.left);
                    }
                    if(head.right != null){
                        queue.offer(head.right);
                    }
                }
                
            }
        }
        return root;
    }
}
