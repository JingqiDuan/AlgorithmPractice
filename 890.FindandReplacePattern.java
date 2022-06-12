class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> results = new ArrayList<>();
        for(String word : words){
            if(isMatch(word, pattern)){
                results.add(word);
            }
        }
        return results;
    }
    public boolean isMatch(String word, String pattern){
        if(word.length() != pattern.length()){
            return false;
        }
        HashMap<Character, Character> mapW = new HashMap<>();
        HashMap<Character, Character> mapP = new HashMap<>();
        for(int i = 0; i < word.length(); i++){
            char w = word.charAt(i);
            char p = pattern.charAt(i);
            if(mapW.containsKey(w) && mapW.get(w) != p || mapP.containsKey(p) && mapP.get(p) != w){
                return false;
            }
            mapW.put(w, p);
            mapP.put(p, w);
        }
        return true;
    }
}
