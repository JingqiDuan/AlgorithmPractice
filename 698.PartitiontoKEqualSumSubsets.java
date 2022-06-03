class Solution{
    public boolean canPartitionKSubsets(int[] nums, int k){
        if(k == 1){
            return true;
        }
        int sum = 0;
        for(int num : nums){
	        sum += num;
        }
        if(sum % k != 0){
            return false;
        }
        Arrays.sort(nums);
        int[] subSum = new int[k];
        int avg = sum / k;
        Arrays.fill(subSum, avg);
        return helper(nums, subSum, nums.length - 1);
    }

    public boolean helper(int[] nums, int[] subSum, int index){
        if(index < 0){
            return true;
        }

        for(int i = 0; i < subSum.length; i++){
            //beat 99% after adding the following
            if(i > 0 && subSum[i] == subSum[i - 1]) continue;
            if(subSum[i] == nums[index] || (subSum[i] - nums[index] >= nums[0])){
                subSum[i] -= nums[index];
                if(helper(nums, subSum, index - 1)){
                    return true;
                }
                subSum[i] += nums[index];
            }
            
        }
        return false;
    }	
}
