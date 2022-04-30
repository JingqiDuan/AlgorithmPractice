class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int n = s.length();
        if(n <= k){
            return n;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int result = 0;
        while(right < n){
            if(map.size() <= k){
                map.put(s.charAt(right), right);
                right++;
            }
            if(map.size() > k){
                int deleteIndex = Collections.min(map.values());
                map.remove(s.charAt(deleteIndex));
                left = deleteIndex + 1;
            }
            result = Math.max(result, right - left);
        }
        return result;
    }
}
