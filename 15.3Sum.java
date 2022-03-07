class Solution {
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
