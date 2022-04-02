class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length <= 1){
            return nums.length;
        }
        int[] dp = new int[nums.length];
        dp[nums.length - 1] = 1;
        int result = 1;
        //pd[i] means sequence start from nums[i], nums[i] as the smallest element
        for(int i = nums.length - 2; i >= 0; i--){
            dp[i] = 1;
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] < nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            //result is not pd[0]
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}
