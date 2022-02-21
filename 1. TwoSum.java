class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int m = -1, n = -1;
        for(int i = 0; i < nums.length; i ++){
            //map(value,index)
            int diff = target - nums[i];
            if(map.containsKey(diff)){
                m = map.get(diff);
                n = i;
            }
            map.put(nums[i], i);
        }
        return new int[]{m, n};
    }
}
