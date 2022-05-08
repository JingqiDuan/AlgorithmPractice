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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return helper(map, inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    public TreeNode helper(HashMap<Integer, Integer> map, int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd){
        if(inStart > inEnd || postStart > postEnd){
            return null;
        }
        int rootValue = postorder[postEnd];
        int rIndex = map.get(rootValue);
        TreeNode root = new TreeNode(rootValue);
        root.left = helper(map, inorder, postorder, inStart, rIndex - 1, postStart, postStart + rIndex - 1 - inStart);
        root.right = helper(map, inorder, postorder, rIndex + 1, inEnd, postStart + rIndex - inStart, postEnd - 1);
        return root;
    }
}
