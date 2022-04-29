class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s){
        int n = s.length();
        if(n < 3){
            return n;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int result = 0;
        while(right < n){
            if(map.size() < 3){
                map.put(s.charAt(right), right);
                right++;
            }
            if(map.size() == 3){
                int deleteIndex = Collections.min(map.values());
                map.remove(s.charAt(deleteIndex));
                left = deleteIndex + 1;
            }
            result = Math.max(result, right - left);
        }
        return result;
    }
}
