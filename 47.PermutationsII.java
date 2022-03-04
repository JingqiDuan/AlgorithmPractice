class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return results;
        }
        Arrays.sort(nums);
        Stack<Integer> subset = new Stack<>();
        boolean[] used = new boolean[nums.length];
        helper(nums, 0, subset, used, results);
        return results;
    }

    private void helper(int[] nums, int depth, Stack<Integer> subset, 
                        boolean[] used ,List<List<Integer>> results){
        if(depth == nums.length){
            results.add(new ArrayList<>(subset));
        }
        for(int i = 0; i < nums.length; i++){
            if(used[i]){
                continue;
            }
                if(i > 0 && nums[i] == nums[i - 1] && !used[i - 1]){//have to check if i-1 is used, otherwise the branch might get pruned
                    continue;
                }
                subset.push(nums[i]);
                used[i] = true;
                helper(nums, depth + 1, subset, used, results);
                subset.pop();
                used[i] = false;
            
        }
    }
}
