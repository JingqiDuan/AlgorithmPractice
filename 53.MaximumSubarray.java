class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int sum = nums[0];
        int startIndex = 0;
        int currentSum = 0;
        //greedy algorithm
        //drop previous elements if current sum is minus
        for(int i = startIndex; i < nums.length; i++){
            currentSum += nums[i];
            if(currentSum > sum){
                sum = currentSum;
            }
            if(currentSum < 0){
                startIndex = i + 1;
                currentSum = 0;
            }
        }
    return sum;
    }
}
