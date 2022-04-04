/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null){
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            ArrayList<Node> level = new ArrayList<>();
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Node head = queue.poll();
                level.add(head);
                if(i == size - 1){
                    head.next = null;
                }
                if(head.left != null){
                    queue.offer(head.left);
                }
                if(head.right != null){
                    queue.offer(head.right);
                }
            }
            for(int i = 0; i < level.size() - 1; i++){
                level.get(i).next = level.get(i + 1);
            }
        }
        return root;
    }
}
