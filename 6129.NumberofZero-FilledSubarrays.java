class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long[] dp=new long[nums.length];
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                continue;
            }
            if(nums[i]==0){
                dp[i]=1;
            }
            if(i-1>=0 && nums[i-1]==0){
                dp[i]+=dp[i-1];
            }
        }
        long count=0;
        for(int i=0;i<dp.length;i++){
            count+=dp[i];
        }
        return count;

    }
}

/*
class Solution {
    public long zeroFilledSubarray(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int len = nums.length;
        while(left < len && right < len){
            while(left < len && nums[left] != 0){
                left++;
            }
            if(left == len){
                break;
            }
            right = left;
            while(right < len && nums[right] == 0){
                right++;
            }
            map.put(right - left, map.getOrDefault(right - left, 0) + 1);
            left = right;
        }
        long result = 0L;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            long key = (long) entry.getKey();
            long val = (long) entry.getValue();
            result += val * (key * (key + 1) / 2);
        }
        return result;
    }
}
*/
