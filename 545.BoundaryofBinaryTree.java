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
    List<Integer> res = new ArrayList<>();
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        if(root==null){
            return res;
        }
        if(root.left==null&&root.right==null){
            res.add(root.val);
            return res;
        }
        res.add(root.val);
        getLeft(root.left);
        getDown(root);
        getRight(root.right);
        return res;
    }

    public void getLeft(TreeNode root){
        if(root==null||(root.left==null&&root.right==null)){
            return ;
        }
        res.add(root.val);
        if(root.left!=null){
            getLeft(root.left);
        }else{
            getLeft(root.right);
        }
    }

    public void getRight(TreeNode root){
        if(root==null||(root.left==null&&root.right==null)){
            return ;
        }
        if(root.right!=null){
            getRight(root.right);
        }else{
            getRight(root.left);
        }
        res.add(root.val);
    }

    public void getDown(TreeNode root){
        if(root.left==null&&root.right==null){
            res.add(root.val);
            return ;
        }
        if(root.left!=null){
            getDown(root.left);
        }
        if(root.right!=null){
            getDown(root.right);
        }
    }
}
