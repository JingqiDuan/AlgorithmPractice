class Solution {
    public int subarraySum(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        //if accumulative sum of two indecies is the same (difference is 0), the sum of elements in between is 0
        //the same applies to k
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int count = 0;
        //init key shoule be 0
        map.put(0, 1);
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(map.containsKey(sum - k)){
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
