class Solution {
    public int findUnsortedSubarray(int[] nums) {
        if(nums.length <= 1){
            return 0;
        }
        int len = nums.length;
        int min = nums[len - 1];
        int max = nums[0];
        int left = len - 1;
        int right = 0;
        for(int i = 0; i < len; i++){
            if(nums[i] < max){
                right = i;
            }else{
                max = nums[i];
            }

            if(nums[len - i - 1] > min){
                left = len - i - 1;
            }else{
                min = nums[len - i - 1];
            }
        }
        return right <= left ? 0 : right - left + 1;
    }
}
