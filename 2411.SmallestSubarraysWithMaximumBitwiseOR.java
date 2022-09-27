class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int len = nums.length;
        //dp[i] note the latest index appear as 1 at its i th bit position
        int[] dp = new int[32];
        Arrays.fill(dp, -1);
        int[] result = new int[len];
        for(int i = len - 1; i >= 0; i--){
            int max = 1;
            for(int j = 0; j < 32; j++){
                if(((nums[i] >> j) & 1) == 1) dp[j] = i;
                //if position j has 1, then calculate length
                if(dp[j] != -1) max = Math.max(max, dp[j] - i + 1);
            }
            result[i] = max;
        }
        return result;
    }
}
