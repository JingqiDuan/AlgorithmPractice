class Solution {
    public String longestWord(String[] words) {
        Arrays.sort(words, (a, b) -> {
            if(a.length() != b.length()){
                return a.length() - b.length();
            }else{
                //why it's b.compareTo(a) ? i.e a - b is minus... omg
                return b.compareTo(a);
            }
        });
        Set<String> set = new HashSet<>();
        set.add("");
        String result = "";
        for(int i = 0; i < words.length; i++){
            String word = words[i];
            if(set.contains(word.substring(0, word.length() - 1))){
                set.add(word);
                result = word;
            }
        }
        return result;
    }
}
