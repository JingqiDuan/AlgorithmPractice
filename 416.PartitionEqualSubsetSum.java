class Solution {
    public boolean canPartition(int[] nums) {
        if(nums.length < 2){
            return false;
        }
        int sum = 0;
        for(int n : nums){
            sum += n;
        }
        if((sum & 1) == 1){
            return false;
        }
        int target = sum / 2;
        int len = nums.length;
        boolean[][] dp = new boolean[len][target + 1];
        //dp[i - 1][target - nums[i] = 0]
        dp[0][0] = true;
        if(nums[0] <= target){
            dp[0][nums[0]] = true;
        }

        for(int i = 1; i < len; i++){
            for(int j = 0; j <= target; j++){
                dp[i][j] = dp[i - 1][j];
                if(nums[i] <= j){
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }                
            }
            if(dp[i][target]){
                return true;
            }
        }
        return dp[len - 1][target];
    }
}
