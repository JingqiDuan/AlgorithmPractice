class Solution {
    public int rob(int[] nums) {
        //if nums[i] + dp[i - 2] > dp[i - 1]
        //dp[i] = dp[ i - 2] + nums[i]
        //dp[i]=max(dp[i−2]+nums[i],dp[i−1])
        if(nums == null || nums.length == 0){
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        if(nums.length > 1){
            dp[1] = Math.max(nums[0], nums[1]);
        }
        for(int i = 2; i < nums.length; i++){
            dp[i] = Math.max(dp[i - 1], (dp[i - 2] + nums[i]));
        }
        return dp[nums.length - 1];
    }
}
