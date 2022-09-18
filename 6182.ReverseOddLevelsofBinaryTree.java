class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {
        helper(root.left, root.right, true);
        return root;
    }
    public void helper(TreeNode left, TreeNode right, boolean isOdd){
        if(left == null || right == null){
            return;
        }
        if(isOdd){
            int tmp = left.val;
            left.val = right.val;
            right.val = tmp;
        }
        helper(left.left, right.right, !isOdd);
        helper(left.right, right.left, !isOdd);
    }
}
