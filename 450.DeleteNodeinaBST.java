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
    public TreeNode deleteNode(TreeNode root, int val) {
        if(root == null){
            return null;
        }
        //find the node to be deleted
        if(val < root.val){
            root.left = deleteNode(root.left, val);
        }else if(val > root.val){
            root.right = deleteNode(root.right, val);
        }else{
            if(root.left == null){
                return root.right;
            }
            if(root.right == null){
                return root.left;
            }
            if(root.left != null && root.right != null){
                //attach left subtree to the lefest node of right subtree
                TreeNode node = root.right;
                while(node.left != null){
                    node = node.left;
                }
                node.left = root.left;
                //replace old root(delete)
                //wrong: root = node;
                root = root.right;
            }
        }
        return root;
    }
}
