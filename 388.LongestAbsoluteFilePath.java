class Solution {
    class Node{
        public int level;
        public int sum;
        public Node(int level, int sum){
            this.level = level;
            this.sum = sum;
        }
    }

    public int lengthLongestPath(String input) {
        String[] splits = input.split("\n");
        Stack<Node> stack = new Stack<>();
        int result = 0;
        int index = 0;
        while(index < splits.length){
            int levelNum = getLevel(splits[index]);
            if(stack.isEmpty()){
                if(splits[index].indexOf('.') != -1){
                    result = Math.max(result, splits[index].length());
                }else{
                    Node newNode = new Node(levelNum, splits[index].length() - levelNum);
                    stack.push(newNode);
                }
                index++;
            }else{
                Node node = stack.peek();
                if(node.level + 1 == levelNum){
                    //+1 is for '/'
                    Node newNode = new Node(levelNum, node.sum + splits[index].length() - levelNum + 1);
                    if(splits[index].indexOf('.') != -1){
                        result = Math.max(result, newNode.sum);
                    }else{
                        stack.push(newNode);
                    }
                    //move on to next split only when it's at the subsequent level
                    index++;
                }else{
                    stack.pop();
                }
            }
        }
        return result;
    }

    public int getLevel(String s){
        int count = 0;
        StringBuilder tmpStr = new StringBuilder();
        while(true){
            tmpStr.append('\t');
            if(s.startsWith(tmpStr.toString())){
                count++;
            }else{
                break;
            }
        }
        return count;
    }
}
