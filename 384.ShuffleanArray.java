class Solution {
    int[] nums;
    int[] original;
    public Solution(int[] nums) {
        this.nums = nums;
        original = new int[nums.length];
        System.arraycopy(nums, 0, original, 0, nums.length);
    }
    
    public int[] reset() {
        return original;
    }
    
    public int[] shuffle() {
        Random random = new Random();
        for(int i = 0; i < nums.length; i++){
            int randIndex = i + random.nextInt(nums.length - i);
            int tmp = nums[i];
            nums[i] = nums[randIndex];
            nums[randIndex] = tmp;
        }
        return nums;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
