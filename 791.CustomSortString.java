class Solution {
    public String customSortString(String order, String s) {
        StringBuilder sb = new StringBuilder();
        int[] counter = new int[26];
        for(char c : s.toCharArray()){
            counter[c - 'a']++;
        }

        for(char c : order.toCharArray()){
            int index = c - 'a';
            if(counter[index] > 0){
                while(counter[index]-- > 0){
                    sb.append((char) (index + 'a'));
                }
            }
        }
        
        for(int i = 0; i < 26; i++){
            if(counter[i] > 0){
                for(int j = 0; j < counter[i]; j++){
                    sb.append((char) (i + 'a'));
                }
            }
        }
        return sb.toString();
    }
}
