class Solution {
    public int rob(int[] nums) {
        if(nums.length <= 1){
            return nums[0];
        }
        if(nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }
        int result = 0;
        result = Math.max(maxProfit(Arrays.copyOfRange(nums, 1, nums.length)),
                          maxProfit(Arrays.copyOfRange(nums, 0, nums.length - 1)));
        return result;
    }

    //dp[i] = max(dp[i - 1], dp[i - 2] + num[i]);
    public int maxProfit(int[] nums){
        int prev = nums[0];
        int cur = Math.max(nums[0], nums[1]);
        int tmp;
        for(int i = 2; i < nums.length; i++){
            tmp = cur;
            cur = Math.max(cur, prev + nums[i]);
            prev = tmp;
        }
        return cur;
    }
}
