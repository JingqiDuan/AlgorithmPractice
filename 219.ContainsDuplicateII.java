class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(k <= 0){
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            if(i > k){
                set.remove(nums[i - k - 1]);
            }
            if(!set.add(nums[i])){
                return true;
            }
        }
        return false;
    }
    /*public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(k == 0){
            return false;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                if(i - map.get(nums[i]) <= k){
                    return true;
                }
            }
            map.put(nums[i], i);
        }
        return false;
    }*/
}
