class Solution {
    class Node{
        Node[] children;
        int score;
        List<Integer> indexList;
        public Node(){
            this.children = new Node[26];
            this.score = 0;
            this.indexList = new ArrayList<>();
        }
    }
    public int[] sumPrefixScores(String[] words) {
        int[] result = new int[words.length];
        Node root = new Node();
        for(int i = 0; i < words.length; i++){
            String word = words[i];
            //reference of root node
            Node head = root;
            for(char c : word.toCharArray()){
                int index = c - 'a';
                if(head.children[index] == null) head.children[index] = new Node();
                head = head.children[index];
                //not the parents score
                head.score++;
            }
            head.indexList.add(i);
        }
        helper(root, 0, result);
        return result;
    }
    public void helper(Node root, int sum, int[] result){
        if(root == null){
            return;
        }
        sum += root.score;
        for(int i : root.indexList){
            result[i] = sum;
        }
        for(Node node : root.children){
            helper(node, sum, result);
        }
    }
}
