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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return helper(map, preorder, 0, preorder.length - 1, inorder, 0, inorder.length -  1);
    }
    public TreeNode helper(HashMap<Integer, Integer> map, int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight){
        if(preLeft > preRight || inLeft > inRight){
            return null;
        }
        int rootVal = preorder[preLeft];
        int rIndex = map.get(rootVal);
        TreeNode root = new TreeNode(preorder[preLeft]);
        root.left = helper(map, preorder, preLeft + 1, preLeft + rIndex - inLeft, inorder, inLeft, rIndex - 1);
        root.right = helper(map, preorder, preLeft + rIndex - inLeft + 1, preRight, inorder, rIndex + 1, inRight);
        return root;
    }
}
