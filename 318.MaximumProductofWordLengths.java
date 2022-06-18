class Solution {
    public int maxProduct(String[] words) {
        int len = words.length;
        int[] mask = new int[len];
        int index = 0;
        for(String word : words){
            int t = 0;
            for(char ch : word.toCharArray()){
                int tmp = 1 << (ch - 'a');
                t |= tmp;
            }
            mask[index++] = t;
        }
        int result = 0;
        for(int i = 0; i < len; i++){
            for(int j = i + 1; j < len; j++){
                int tmpLen = 0;
                if((mask[i] & mask[j]) == 0){
                    tmpLen = words[i].length() * words[j].length();
                }
                result = Math.max(result, tmpLen);
            }
        }
        return result;
    }
}
