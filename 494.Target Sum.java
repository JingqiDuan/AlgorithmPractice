class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        int diff = sum - target;
        if(diff < 0 || (diff & 1) == 1){
            return 0;
        }
        int neg = diff / 2;
        int[][] dp = new int[nums.length + 1][neg + 1];
        dp[0][0] = 1;
        for(int i = 1; i <= nums.length; i++){
            for(int j = 0; j <= neg; j++){
                dp[i][j] = dp[i - 1][j];
                if(j >= nums[i - 1]){
                    //wrong: dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - nums[i - 1]] + 1);
                    dp[i][j] += dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[nums.length][neg];
    }
}

/*
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return helper(nums, 0, target, 0);
    }
    public int helper(int[] nums, int index, int target, int count){
        if(index == nums.length){
            if(target == 0){
                count++;
            }
            return count;
        }
            count = helper(nums, index + 1, target + nums[index], count);
            count = helper(nums, index + 1, target - nums[index], count);
        return count;
    }
}
*/
