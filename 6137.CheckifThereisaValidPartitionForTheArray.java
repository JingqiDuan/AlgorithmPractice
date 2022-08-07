class Solution {
    public boolean validPartition(int[] nums) {
        int len = nums.length;
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for(int i = 2; i <= len; i++){
            dp[i] = (dp[i - 2] && nums[i - 1] == nums[i - 2])
                    || (i > 2 && dp[i - 3] && nums[i - 1] - nums[i - 2] == 1
                        && nums[i - 1] - nums[i - 3] == 2)
                    || ( i > 2 && dp[i - 3] && nums[i - 1] == nums[i - 2]
                        && nums[i - 2] == nums[i - 3]);
        }
        return dp[len];
    }
}
