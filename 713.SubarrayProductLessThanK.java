class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k == 0){
            return 0;
        }
        int len = nums.length;
        int result = 0;
        int prod = 1;
        int left = 0;
        for(int i = 0; i < len; i++){
            prod *= nums[i];
            while(prod >= k && left <= i){
                prod /= nums[left];
                left++;
            }
            result += i - left + 1;
        }
        return result;
    }
}
