class Solution {
    public int countSquares(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0){
            return 0;
        }
        int result = 0;
        //dp[i][j] = min(...) + 1
        //length of biggest square -> num of squares
        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = matrix[i][j];
                }else if(matrix[i][j] != 0){
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }else{
                    //dp[i][j] means biggest length of a square starting from right bottom i, j 
                    dp[i][j] = 0;
                }
                result += dp[i][j];
            }
        }
        return result;
    }
}
