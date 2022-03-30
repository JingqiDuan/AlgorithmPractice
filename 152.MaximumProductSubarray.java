class Solution {
    public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int result = nums[0];
        for(int n : nums){
            result = Math.max(result, n);
        }
        int maxVal = 1;
        int minVal = 1;
        for(int n : nums){
            if(n == 0){
                maxVal = 1;
                minVal = 1;
                continue;
            }
            int tmp = maxVal * n;
            maxVal = Math.max(maxVal * n, Math.max(minVal * n, n));
            minVal = Math.min(tmp, Math.min(minVal * n, n));
            result = Math.max(result, maxVal);
        }
        return result;
    }
}
