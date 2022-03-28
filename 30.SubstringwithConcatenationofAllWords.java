class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if(s.length() == 0 || s == null || words.length == 0 || words == null){
            return result;
        }
        int wordLen = words[0].length();
        int wordNum = words.length;
        for(int i = 0; i < s.length(); i++){
            if(i + wordLen * wordNum - 1 > s.length() - 1){
                break;
            }
            ArrayList<String> wordList = new ArrayList<>();
            for(String word : words){
                wordList.add(word);
            }
            int j = i + wordLen * wordNum;
            //get substring with total length of words
            String frac = s.substring(i, j);
            //check each word in substring
            //mind the range of k
            for(int k = 0; k <= j - i - wordLen; k += wordLen){
                String singleWord = frac.substring(k, k + wordLen);
                if(!wordList.contains(singleWord)){
                    break;
                }else{
                    wordList.remove(singleWord);
                }
            }
            if(wordList.size() == 0){
                result.add(i);
            }
        }
        return result;
    }
}
