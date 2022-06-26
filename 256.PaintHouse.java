class Solution {
    public int minCost(int[][] costs) {
        int rowLen = costs.length;
        int[][] dp = new int[rowLen + 1][4];
        for(int i = 1; i <= rowLen; i++){
            for(int j = 1; j <= 3; j++){
                if(j == 1){
                    dp[i][j] = Math.min(dp[i - 1][2], dp[i - 1][3]) + costs[i - 1][j - 1];
                }else if(j == 2){
                    dp[i][j] = Math.min(dp[i - 1][1], dp[i - 1][3]) + costs[i - 1][j - 1];
                }else{
                    dp[i][j] = Math.min(dp[i - 1][1], dp[i - 1][2]) + costs[i - 1][j - 1];
                }
            }
        }
        return Math.min(Math.min(dp[rowLen][1], dp[rowLen][2]), dp[rowLen][3]);
    }
}
