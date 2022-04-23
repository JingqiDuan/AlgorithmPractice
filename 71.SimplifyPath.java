class Solution {
    public String simplifyPath(String path) {
        if(path == null || path.length() == 0){
            return "";
        }
        String[] splits = path.split("/");
        Deque<String> deque = new LinkedList<>();
        for(int i = 0; i < splits.length; i++){
            if(splits[i].equals("..")){
                if(!deque.isEmpty()){
                    deque.pollLast();
                }
            }else if(!splits[i].equals(".") && splits[i].length() > 0){
                deque.offerLast("/" + splits[i]);
            }
        }
        if(deque.isEmpty()){
            deque.offerLast("/");
        }
        StringBuilder result = new StringBuilder();
        while(!deque.isEmpty()){
            result.append(deque.pollFirst());
        }
        return result.toString();
    }
}
