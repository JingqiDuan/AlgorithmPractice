class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rowNum = obstacleGrid.length;
        int colNum = obstacleGrid[0].length;
        int[][] dp = new int[rowNum][colNum];
        //cornor case
        if(obstacleGrid[0][0] == 1){
            return 0;
        }
        for(int i = 0; i < rowNum; i++){
            if(obstacleGrid[i][0] == 1){
                dp[i][0] = 0;
                //don't forget
                break;
            }else{
                dp[i][0] = 1;
            }
        }
        for(int i = 0; i < colNum; i++){
            if(obstacleGrid[0][i] == 1){
                dp[0][i] = 0;
                break;
            }else{
                dp[0][i] = 1;
            }
        }
        for(int i = 1; i < rowNum; i++){
            for(int j = 1; j < colNum; j++){
                if(obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                }else{
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[rowNum - 1][colNum - 1];
    }
}
