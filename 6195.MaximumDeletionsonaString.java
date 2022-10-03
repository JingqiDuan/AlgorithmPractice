class Solution {
    public int deleteString(String s) {
        int len = s.length();
        int[][] lcp = new int[len + 1][len + 1];
        for(int i = len - 1; i >= 0; i--){
            for(int j = len - 1; j > i; j--){
                if(s.charAt(i) == s.charAt(j)) lcp[i][j] = lcp[i + 1][j + 1] + 1;
            }
        }

        int[] dp = new int[len];
        for(int i = len - 1; i >= 0; i--){
            for(int j = 1; i + 2 * j <= len; j++){
                if(lcp[i][i + j] >= j){
                    dp[i] = Math.max(dp[i], dp[i + j]);
                }
            }
            dp[i]++;
        }
        return dp[0];
    }
}
