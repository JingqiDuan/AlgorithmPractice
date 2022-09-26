class Solution {
    public int[] missingTwo(int[] nums) {
        int n = nums.length + 2;
        int sum = (1 + n) * n / 2;
        for(int num : nums){
            sum -= num;
        }
        int mid = sum / 2;
        int midSum = mid * (mid + 1) / 2;
        for(int num : nums){
            if(num <= mid) midSum -= num;
        }
        return new int[]{midSum, sum - midSum};
    }
}
