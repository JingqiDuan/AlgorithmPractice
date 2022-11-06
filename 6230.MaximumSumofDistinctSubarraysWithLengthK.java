class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long result = 0L, cur = 0L;
        int[] cnt = new int[(int) 1e5 + 10];
        int rep = 0;
        for(int i = 0; i < k; i++){
            cnt[nums[i]]++;
            cur += nums[i];
            if(cnt[nums[i]] > 1) rep++;
        }
        if(rep == 0) result = cur;
        
        for(int i = k; i < nums.length; i++){
            cur -= nums[i - k];
            if(--cnt[nums[i - k]] >= 1) rep--;
            cur += nums[i];
            if(++cnt[nums[i]] > 1) rep++;
            if(rep == 0) result = Math.max(result, cur);
        }
        return result;
    }
}
