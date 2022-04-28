class Solution {
    public int characterReplacement(String s, int k) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int[] counter = new int[26];
        int left = 0;
        int right = 0;
        int maxSame = 0;
        while(right < s.length()){
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);
            counter[rightChar - 'A']++;
            maxSame = Math.max(maxSame, counter[rightChar - 'A']);
            if(right - left + 1 - maxSame > k){
                left++;
                counter[leftChar - 'A']--;
            }
            right++;
        }
        return right - left;
    }
}
