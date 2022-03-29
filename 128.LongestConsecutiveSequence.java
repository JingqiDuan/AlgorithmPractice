class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0 || nums == null){
            return 0;
        }
        HashSet<Integer> set = new HashSet<>();
        for(int n : nums){
            set.add(n);
        }
        int maxLen = 0;
        for(int i = 0; i < nums.length; i++){
            if(!set.contains(nums[i] - 1)){
                int len = 0;
                while(set.contains(nums[i] + len)){
                    len++;
                }
                maxLen = Math.max(maxLen, len);
            }
        }
        return maxLen;
    }
}
