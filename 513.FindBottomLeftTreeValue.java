class Solution {
    int maxHeight = -1;
    int result = 0;
    public int findBottomLeftValue(TreeNode root) {
        if(root == null){
            return 0;
        }
        helper(root, 0);
        return result;
    }
    public void helper(TreeNode root, int height){
        if(root == null){
            return;
        }
        helper(root.left, height + 1);
        if(height > maxHeight){
            maxHeight = height;
            result = root.val;
        }
        helper(root.right, height + 1);
    }
}

/*
class Solution {
    public int findBottomLeftValue(TreeNode root) {
        if(root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            root = queue.poll();
            if(root.right != null){
                queue.offer(root.right);
            }
            if(root.left != null){
                queue.offer(root.left);
            }
        }
        return root.val;
    }
}
*/
