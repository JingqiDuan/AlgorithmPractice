class Solution {
    public long countBadPairs(int[] nums) {
        long result = 0L;
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int diff = nums[i] - i;
            map.put(diff, map.getOrDefault(diff, 0) + 1);
        }
        long goodCount = 0L;
        for(int val : map.values()){
            goodCount += (long) val * ((long) val - 1) / 2;
        }
        result = (long) len * ((long) len - 1) / 2 - goodCount;
        return result;
    }
}
