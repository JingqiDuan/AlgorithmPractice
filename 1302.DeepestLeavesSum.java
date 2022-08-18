class Solution {
    int maxLevel = -1;
    int sum = 0;
    public int deepestLeavesSum(TreeNode root) {
        helper(root, 0);
        return sum;
    }
    public void helper(TreeNode root, int level){
        if(root == null){
            return;
        }
        if(level > maxLevel){
            maxLevel = level;
            sum = root.val;
        }else if(level == maxLevel){
            sum += root.val;
        }
        helper(root.left, level + 1);
        helper(root.right, level + 1);
    }
}
