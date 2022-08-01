class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>();
        for(String word : wordList){
            set.add(word);
        }
        if(!set.contains(endWord)){
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int level = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                String curWord = queue.poll();
                char[] wordArr = curWord.toCharArray();
                for(int j = 0; j < wordArr.length; j++){
                    for(char k = 'a'; k <= 'z'; k++){
                        if(wordArr[j] == k){
                            continue;
                        }
                        wordArr[j] = k;
                        String newStr = String.valueOf(wordArr);
                        if(newStr.equals(endWord)){
                            return level + 1;
                        }
                        if(set.contains(newStr)){
                            set.remove(newStr);
                            queue.offer(newStr);
                        }
                        wordArr[j] = curWord.charAt(j);
                    }
                }
            }
            level++;
        }
        return 0;
    }
}
