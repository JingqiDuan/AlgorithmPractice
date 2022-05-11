class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int[][][] dp = new int[len + 1][m + 1][n + 1];
        for(int i = 1; i < len + 1; i++){
            for(int j = 0; j < m + 1; j++){
                for(int k = 0; k < n + 1; k++){
                    int[] zeroAndOne = getZeroAndOne(strs[i - 1]);
                    int zero = zeroAndOne[0];
                    int one = zeroAndOne[1];
                    dp[i][j][k] = dp[i - 1][j][k];
                    if(zero <= j && one <= k){
                        dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i - 1][j - zero][k - one] + 1);
                    }
                }
            }
        }
        return dp[len][m][n];
    }
    public int[] getZeroAndOne(String str){
        int zero = 0;
        int one = 0;
        for(char c : str.toCharArray()){
            if(c - '0' == 0){
                zero++;
            }else{
                one++;
            }
        }
        return new int[]{zero, one};
    }
}
