class Solution {
	public long countSubarrays(int[] nums, int minK, int maxK) {
		long min = -1, max = -1, index = -1, count = 0;
		for (int i = 0; i < nums.length; i++) {
			count += Math.max(0, Math.min(min = nums[i] == minK ? i : min, max = nums[i] == maxK ? i : max)
					- (index = nums[i] < minK || nums[i] > maxK ? i : index));
		}
		return count;
	}
}
