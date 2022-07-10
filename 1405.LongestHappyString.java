class Solution {
    class Node{
        char label;
        int freq;
        public Node(char label, int freq){
            this.label = label;
            this.freq = freq;
        }
    }
    public String longestDiverseString(int a, int b, int c) {
        if(a == 0 && b == 0 && c == 0){
            return "";
        }
        StringBuilder result = new StringBuilder();
        Node[] nodes = new Node[]{new Node('a', a), new Node('b', b), new Node('c', c)};
        while(true){
            Arrays.sort(nodes, (Node tmp1, Node tmp2) -> tmp2.freq - tmp1.freq);
            boolean hasNext = false;
            for(Node node : nodes){
                if(node.freq <= 0){
                    break;
                }
                int len = result.length();
                if(len >= 2 && result.charAt(len - 2) == node.label && result.charAt(len - 1) == node.label){
                    continue;
                }
                hasNext = true;
                result.append(node.label);
                node.freq--;
                break;
            }
            if(!hasNext){
                break;
            }
        }
        return result.toString();
    }
}
