class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null){
            return 0;
        }
        char[] charArr = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0, max = 0;
        //sliding window
        for(int i = 0; i < charArr.length; i++){
            if(map.containsKey(charArr[i])){
                left = Math.max(left, map.get(charArr[i]) + 1);
            }
            //update value each time
            map.put(charArr[i], i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }
}
