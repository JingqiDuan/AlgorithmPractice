class Solution {
    public boolean validPalindrome(String s) {
        if(s == null || s.length() == 0){
            return true;
        }
        int left = 0, right = s.length() - 1;
        while(left < right){
            if(s.charAt(left) == s.charAt(right)){
                left++;
                right--;
            }else{
                break;   
            }
        }
        if(left >= right){
            return true;
        }
        return isValid(s, left + 1, right) || isValid(s, left, right - 1);
    }

    private boolean isValid(String s, int left, int right){
        while(left < right){
            if(s.charAt(left) == s.charAt(right)){
                left++;
                right--;
            }else{
                return false;
                }
            }
            return true;
    }
}
