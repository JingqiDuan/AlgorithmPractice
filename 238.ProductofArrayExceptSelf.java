class Solution {
    public int[] productExceptSelf(int[] nums) {
        if(nums == null || nums.length == 0){
            return new int[0];
        }
        int[] result = new int[nums.length];
        for(int i = 0, tmp = 1; i < nums.length; i++){
            result[i] = tmp;
            tmp *= nums[i];
        }

        for(int i = nums.length - 1, tmp = 1; i >= 0; i--){
            result[i] *= tmp;
            tmp *= nums[i];
        }
        return result;
    }
}
