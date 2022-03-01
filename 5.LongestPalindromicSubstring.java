class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0){
            return "";
        }
        int len1, len2, length;
        int start = 0, end = 0;
        for(int i = 0; i < s.length(); i++){
            len1 = expandFromMiddle(s, i, i);//e.g racecar
            len2 = expandFromMiddle(s, i, i + 1);//e.g abba
            length = Math.max(len1, len2);
            if(length > end - start){
                start = i - (length - 1) / 2;//test on both cases
                end = i + length / 2; 
            }
        }
        return s.substring(start, end + 1);//substring(included, not included)
    }

    private int expandFromMiddle(String s, int left, int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return right - left - 1;//test on end of while loop
    }
}
