class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return results;
        }
        Stack<Integer> subset = new Stack<>();
        boolean[] used = new boolean[nums.length];
        helper(nums, 0, subset, used, results);
        return results;
    }

    private void helper(int[] nums, int depth, Stack<Integer> subset, 
                        boolean[] used, List<List<Integer>> results){
        if(depth == nums.length){
             results.add(new ArrayList<>(subset));
             return;
        }
        for(int i = 0; i < nums.length; i++){
            if(!used[i]){
                subset.push(nums[i]);
                used[i] = true;
                helper(nums, depth + 1, subset, used, results);
                used[i] = false;
                subset.pop();
            }
        }
    }
}

