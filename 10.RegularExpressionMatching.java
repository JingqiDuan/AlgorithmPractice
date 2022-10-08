class Solution {
    public boolean isMatch(String s, String p) {
        int len1 = s.length(), len2 = p.length();
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        dp[0][0] = true;
        for(int i = 0; i <= len1; i++){
            for(int j = 1; j <= len2; j++){
                if(j >= 2 && p.charAt(j - 1) == '*'){
                    dp[i][j] = dp[i][j - 2] || i > 0 && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') && dp[i - 1][j];
                }else if(i > 0 && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.')){
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        return dp[len1][len2];
    }
}
