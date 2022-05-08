class Solution {
    public int myAtoi(String s) {
        //trim first the check conor case.   i.e "  "
        s = s.trim();
        if(s == null || s.length() == 0){
            return 0;
        }
        boolean isNegative = false;   
        int left = 0;
        int right = 0;
        if(Character.isDigit(s.charAt(0)) || s.charAt(0) == '-' || s.charAt(0) == '+'){
            if(s.charAt(0) == '-'){
                isNegative = true;
                left++;
            }
            if(s.charAt(0) == '+'){
                left++;
            }
            right = left;
            while(right < s.length()){
                if(Character.isDigit(s.charAt(right))){
                    long curValue = Long.parseLong(s.substring(left, right + 1));
                    if(curValue > Integer.MAX_VALUE){
                        return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                    }
                    right++;
                }else{
                    break;
                }
            }
        }else{
            return 0;
        }
        int result = 0;
        while(left < right){
            result = result * 10 + (s.charAt(left) - '0');
            left++;
        }
        return isNegative ? -result : result;
    }
}
