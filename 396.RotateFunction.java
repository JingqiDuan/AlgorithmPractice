class Solution {
    public int maxRotateFunction(int[] nums) {
        int len = nums.length;
        int arrSum = Arrays.stream(nums).sum();
        int t = 0;
        for(int i = 0; i < len; i++){
            t += nums[i] * i;
        }
        int result = t;
        for(int i = 1; i < len; i++){
            t += arrSum - nums[len - i] * len;
            result = Math.max(result, t);
        }
        return result;
    }
}
