class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }
        int[] tmp = new int[n + 2];
        tmp[0] = 1;
        tmp[n + 1] = 1;
        for(int i = 0; i < n; i++){
            tmp[i + 1] = nums[i];
        }
        int[][] dp = new int[n + 2][n + 2];
      //search between (i, j) i, j not included
        for(int len = 3; len <= n + 2; len++){
            for(int i = 0; i <= n + 2 - len; i++){
                int val = 0;
                for(int k = i + 1; k < i + len - 1; k++){
                    int left = dp[i][k];
                    int right = dp[k][i + len - 1];
                    val = Math.max(val, left + right + tmp[i] * tmp[k] * tmp[i + len - 1]);
                }
                dp[i][i + len - 1] = val;
            }
        }
        return dp[0][n + 1];
    }
}
