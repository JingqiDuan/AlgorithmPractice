class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        int len = nums.length;
        if(len == 0){
            String tmp = helper(lower - 1, upper + 1);
            result.add(tmp);
            return result;
        }
        if(lower != nums[0]){
            result.add(helper(lower - 1, nums[0]));
        }
        for(int i = 0; i < len - 1; i++){
            if(nums[i] + 1 < nums[i + 1]){
                result.add(helper(nums[i], nums[i + 1]));
            }
        }
        if(upper != nums[len - 1]){
            result.add(helper(nums[len - 1], upper + 1));
        }
        return result;
    }

    public String helper(int left, int right){
        StringBuilder sb = new StringBuilder();
        if(left + 2 == right){
            sb.append(left + 1);
        }else{
            sb.append(left + 1);
            sb.append("->");
            sb.append(right - 1);
        }
        return sb.toString();
    }
}
