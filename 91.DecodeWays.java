class Solution {
    public int numDecodings(String s){
        if(s == null || s.length() == 0){
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for(int i = 1; i <= n; i++){
            if(s.charAt(i - 1) != '0'){
                dp[i] += dp[i - 1];
            }
            if(i > 1 && s.charAt(i - 2) != '0' && ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26)){
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }
    /*public int numDecodings(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        //dp[i] = dp[i-1] use last two
        //dp[i] = dp[i-2] use last one
        int n = s.length();
        int prev1 = 1, prev2 = 0;
        int result = 0;
        for(int i = 0; i < n; i++){
            result = 0;
            if(s.charAt(i) != '0'){
                result += prev1;
            }
            if(i > 0 && s.charAt(i - 1) != '0' && ((s.charAt(i - 1) - '0') * 10 + (s.charAt(i) - '0') <= 26)){
                result += prev2;
            }
            prev2 = prev1;
            prev1 = result;
        }
        return result;
    }*/
}
