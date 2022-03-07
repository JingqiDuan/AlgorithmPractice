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
class BSTIterator {
    private TreeNode root;
    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        this.root = root;
        stack = new Stack<>();
    }
    
    public int next() {
        while(root != null){
            stack.push(root);
            root = root.left;
        }
        root = stack.pop();
        TreeNode tmp = root;
        root = root.right;
        return tmp.val;
    }

    public boolean hasNext() {
        return root != null || !stack.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
