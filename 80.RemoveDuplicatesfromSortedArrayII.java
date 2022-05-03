class Solution {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if(len < 2){
            return len;
        }
        int left = 2;
        int right = 2;
        while(right < len){
            if(nums[left - 2] != nums[right]){
                nums[left] = nums[right];
                left++;
            }
            right++;
        }
        return left;
    }
}
