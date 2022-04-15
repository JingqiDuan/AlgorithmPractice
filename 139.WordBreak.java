class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        for(String str : wordDict){
            set.add(str);
        }
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i = 1; i <= s.length(); i++){
            for(int j = 0; j < i; j++){
                if(dp[j] && set.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}

/*class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Queue<Integer> queue = new LinkedList<>();
        int totalLen = s.length();
        //border case
        boolean[] visited = new boolean[totalLen + 1];
        queue.offer(0);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int start = queue.poll();
                for(String word : wordDict){
                    int nextStart = start + word.length();
                    if(nextStart > totalLen || visited[nextStart] == true){
                        continue;
                    }
                    //it's next word
                    if(s.indexOf(word, start) == start){
                        if(nextStart == totalLen){
                            return true;
                        }
                        visited[start] = true;
                        queue.add(nextStart);
                        visited[nextStart] = true;
                    }
                }
            }
        }
        return false;
    }
}*/

/*class Solution {
    //dfs
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        for(String str : wordDict){
            set.add(str);
        }
        //boolean is not convenient for java
        int[] cache = new int[s.length()];
        return helper(s, set, 0, cache, "");
    }
    public boolean helper(String s, HashSet<String> set, int start, int[] cache, String result){
        if(start >= s.length()){
            if(s.equals(result)){
               return true; 
            }
            return false;
        }
        if(cache[start] == 2){
            return true;
        }else if(cache[start] == 1){
            return false;
        }
        for(int i = start; i < s.length(); i++){
            String subStr = s.substring(start, i + 1);
            if(set.contains(subStr)){
                //true -> 2
                cache[start] = 2;
                if(helper(s, set, i + 1, cache, result + subStr)){
                    return true;
                }
            }
            cache[start] = 1;
        }
        return false;
    }
}*/
