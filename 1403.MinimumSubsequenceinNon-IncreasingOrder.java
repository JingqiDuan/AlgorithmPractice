class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int sum = 0;
        Arrays.sort(nums);
        for(int num : nums){
            sum += num;
        }
        int newSum = 0;
        for(int i = nums.length - 1; i >= 0; i--){
            sum -= nums[i];
            newSum += nums[i];
            result.add(nums[i]);
            if(sum < newSum){
                break;
            }
        }
        return result;
    }
}
