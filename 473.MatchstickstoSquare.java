class Solution {
    public boolean makesquare(int[] nums) {
        if (nums.length < 4) return false;
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % 4 != 0) return false;
        Arrays.sort(nums);
        return helper(nums, nums.length - 1, new int[4], sum / 4);
    }

    private boolean helper(int[] nums, int pos, int[] sums, int avg) {
        if (pos == -1)
            return sums[0] == avg && sums[1] == avg && sums[2] == avg;
        for (int i = 0; i < 4; ++i) {
            if (sums[i] + nums[pos] > avg) continue;
            sums[i] += nums[pos];
            if (helper(nums, pos - 1, sums, avg))
                return true;
            sums[i] -= nums[pos];
        }
        return false;
    }
}
