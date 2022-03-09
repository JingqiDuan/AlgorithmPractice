class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length < 4){
            return result;
        }
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++){
            if(i > 0 && nums[i] == nums[i - 1]){
                    continue;
                }
            for(int j = i + 1; j < nums.length - 1; j++){
                if(j > i + 1 && nums[j] == nums[j - 1]){
                    continue;
                }
                findTwoSum(nums, i, j, target, result);
            }
        }
        return result; 
    }

    private void findTwoSum(int[] nums, int indexA, int indexB, int target, List<List<Integer>> result){
        int left = indexB + 1;
        int right = nums.length - 1;
        for(int i = indexB; i < nums.length; i++){//don't forget to continue searching more
            while(left < right){
                int diff = target - nums[right] - nums[indexA] - nums[indexB];
                if(nums[left] < diff){
                    left++;
                }else if(nums[left] > diff){
                    right--;
                }else{
                    ArrayList<Integer> subset = new ArrayList<>();
                    subset.add(nums[indexA]);
                    subset.add(nums[indexB]);
                    subset.add(nums[left]);
                    subset.add(nums[right]);
                    result.add(subset);
                    left++; //easy to forget
                    right--;
                    while(left < right && nums[left] == nums[left - 1]){//easy to forget
                        left++;
                    }
                    break;//easy to forget
                }
            }
        }
    }
}
