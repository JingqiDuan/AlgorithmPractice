class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return results;
        }
        Arrays.sort(nums);
        //a+b+c=0 => a=-(b+c)
        for(int i = 0; i < nums.length; i++){
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            findTwoSum(nums, i, results);
        }
        return results;
    }

    private void findTwoSum(int[] nums, int index, List<List<Integer>> results){
        int target = -nums[index];
        int left = index + 1;
        int right = nums.length - 1;
        for(int i = index; i < nums.length - 1; i++){
            while(left < right){
                if(nums[left] < target - nums[right]){
                    left++;
                }else if(nums[left] > target - nums[right]){
                    right--;
                }else{
                    ArrayList<Integer> triple = new ArrayList<>();
                    triple.add(nums[index]);
                    triple.add(nums[left]);
                    triple.add(nums[right]);
                    results.add(triple);
                    left++;
                    right--;
                    while(left < right && nums[left] == nums[left - 1]){
                        left++;
                    }
                }
            }
        }
    }
    
}

/* class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return results;
        }
        Arrays.sort(nums);
        Stack<Integer> path = new Stack<>();
        helper(nums, 0, path, 0, results);
        return results;
    }
    private void helper(int[] nums, int start, Stack<Integer> path, 
                        int sum, List<List<Integer>> results){
        if(sum == 0 && path.size() == 3){
            results.add(new ArrayList<>(path));
        }
        for(int i = start; i < nums.length; i++){
            if(i > 0 && nums[i] == nums[i - 1] && i != start){//deduplicate between defferent levels
                continue;
            }
            path.push(nums[i]);
            helper(nums, i + 1, path, sum + nums[i], results);
            path.pop();
        }
    }
}
*/
