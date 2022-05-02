class Solution {
    public int longestSubstring(String s, int k) {
        int n = s.length();
        if(n < k){
            return 0;
        }
        int[] counter = new int[26];
        for(int i = 0; i < n; i++){
            counter[s.charAt(i) - 'a']++;
        }
        for(int i = 0; i < n; i++){
            if(counter[s.charAt(i) - 'a'] < k){
                int left = longestSubstring(s.substring(0, i), k);
                int right = longestSubstring(s.substring(i + 1, n), k);
                return Math.max(left, right);
            }
        }
        return n;
    }
}
