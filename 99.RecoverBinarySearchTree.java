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
    public void recoverTree(TreeNode root) {
        ArrayList<Integer> arr = new ArrayList<>();
        inorder(root, arr);
        int[] twoNode = findTwoNode(arr);
        swapNode(root, twoNode, 2);
    }
    public void inorder(TreeNode root, ArrayList<Integer> arr){
        if(root == null){
            return;
        }
        inorder(root.left, arr);
        arr.add(root.val);
        inorder(root.right, arr);
    }
    public int[] findTwoNode(ArrayList<Integer> arr){
        int index1 = -1;
        int index2 = -1;
        for(int i = 0; i < arr.size() - 1; i++){
            if(arr.get(i) > arr.get(i + 1)){
                index2 = i + 1;
                if(index1 == -1){
                    index1 = i;
                }else{
                    break;
                }
            }
        }
        int a = arr.get(index1);
        int b = arr.get(index2);
        return new int[]{a, b};
    }
    public void swapNode(TreeNode root, int[] twoNode, int count){
        if(root == null){
            return;
        }
        swapNode(root.left, twoNode, count);
        int a = twoNode[0];
        int b = twoNode[1];
        if(root.val == a || root.val == b){
            root.val = root.val == a ? b : a;
            if(--count == 0){
                return;
            }
        }
        swapNode(root.right, twoNode, count);
    }
}
