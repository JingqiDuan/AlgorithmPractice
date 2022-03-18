class Solution {
    /*public int missingNumber(int[] nums) {
        int n = nums.length;
        int complete = n * (n + 1) / 2;
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        return complete - sum;
    }
    */
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int xor = 0;
        for(int num : nums){
            xor ^= num;
        }
        for(int i = 0; i <= n; i++){
            xor ^= i;
        }
        return xor;
    }
}
