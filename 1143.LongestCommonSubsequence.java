class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        if(text1 == null || text2 == null || text1.length() == 0 || text2.length() == 0){
            return 0;
        }
        int rows = text1.length();
        int cols = text2.length();
        int[][] dp = new int[rows + 1][cols + 1];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(text1.charAt(i) == text2.charAt(j)){
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                }else{
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        return dp[rows][cols];
    }
}
