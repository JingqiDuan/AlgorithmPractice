class Solution {
    class Node{
        private String str;
        private int left;
        private int right;
        public Node(String str, int left, int right){
            this.str = str;
            this.left = left;
            this.right = right;
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> results = new ArrayList<>();
        if(n == 0){
            return results;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node("", n, n));
        while(!queue.isEmpty()){
            Node node = queue.poll();
            if(node.left > 0){
                queue.offer(new Node(node.str + "(", node.left - 1, node.right));
            }
            if(node.right > 0 && node.left < node.right){
                queue.offer(new Node(node.str + ")", node.left, node.right - 1));
            }
            if(node.str.length() == 2 * n){
                results.add(node.str);
            }
        }
        return results;
    }
}
