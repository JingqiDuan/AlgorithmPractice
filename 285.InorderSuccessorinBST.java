/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private TreeNode ans = null;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        inOrder(root, p);
        return ans;
    }

    private void inOrder(TreeNode root, TreeNode p) {
        if(root == null || ans != null){
            return;
        }
        inOrder(root.left, p);
        //ans == null -> get first value bigger than p.val
        if(ans == null && root.val > p.val){
            ans = root;
        }
        inOrder(root.right, p);
    }

    /*public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        ArrayList<TreeNode> inorderList = new ArrayList<>();
        HashMap<TreeNode, Integer> map = new HashMap<>();
        helper(root, inorderList, map);
        int ansIndex = map.get(p) + 1;
        if(ansIndex >= inorderList.size()){
            return null;
        }
        return inorderList.get(ansIndex);
    }

    public void helper(TreeNode root, ArrayList<TreeNode> inorderList, HashMap<TreeNode, Integer> map){
        if(root == null){
            return;
        }
        helper(root.left, inorderList, map);
        inorderList.add(root);
        map.put(root, map.size());
        helper(root.right, inorderList, map);
    }*/
}
