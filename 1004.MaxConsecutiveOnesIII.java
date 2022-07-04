class Solution {
    public int longestOnes(int[] nums, int k) {
        int len = nums.length;
        int result = 0;
        int right = 0;
        int flip = 0;
        for(int i = 0; i < len; i++){
            while(right < len && (nums[right] == 1 || flip < k)){
                if(nums[right] == 0){
                    flip++;
                }
                right++;
            }
            result = Math.max(result, right - i);
            if(nums[i] == 0){
                flip--;
            }
        }
        return result;
    }
}
