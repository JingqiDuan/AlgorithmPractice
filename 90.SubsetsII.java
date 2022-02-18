class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null){//null
            return result;
        }
        if(nums.length == 0){
            result.add(new ArrayList<>());//[]
            return result;
        }
        Arrays.sort(nums);
        ArrayList<Integer> subset = new ArrayList<>();
        helper(nums, 0, subset, result);
        return result;
    }
    private void helper(int[] nums, int startIndex,
                        ArrayList<Integer> subset,
                        List<List<Integer>> result){
        result.add(new ArrayList<Integer>(subset));
        for(int i = startIndex; i < nums.length; i ++){
            if(i != 0 && nums[i] == nums[i - 1] && i != startIndex){//why i != startIndex
                continue;
            }
            subset.add(nums[i]);
            //startIndex means the previous one, the base, dont write startIndex ++;
            helper(nums, i + 1, subset, result);
            subset.remove(subset.size() - 1);
        }
    }
}
