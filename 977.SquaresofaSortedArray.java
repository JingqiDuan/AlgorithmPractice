class Solution {
    public int[] sortedSquares(int[] nums) {
        if(nums.length == 0 || nums == null){
            return nums;
        }
        int left = 0;
        int right = nums.length - 1;
        int[] result = new int[nums.length];
        int index = nums.length - 1;
        while(right >= 0 && left <= nums.length - 1 && left <= right){
            if(nums[left] * nums[left] > nums[right] * nums[right]){
                result[index--] = nums[left] * nums[left];
                left++;
            }else{
                result[index--] = nums[right] * nums[right];
                right--;
            }
        }
        return result;
    }
}
