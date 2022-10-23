class Solution {
    public int subarrayGCD(int[] nums, int k) {
        int len = nums.length, result = 0;
        for(int i = 0; i < len; i++){
            int d = 0;
            for(int j = i; j < len; j++){
                d = gcd(d, nums[j]);
                if(d == k) result++;
                if(d == 1 && k != 1) break;
            }
        }
        return result;
    }
    public int gcd(int a, int b){
        int result = b;
        while(b != 0){
            result = b;
            b = a % b;
            a = result;
        }
        return result;
    }
}
