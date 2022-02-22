class Solution {
    public int removeElement(int[] nums, int val) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int p1 = 0;
        for(int p2 = 0; p2 < nums.length; p2++){
            if(nums[p2] != val){
                nums[p1] = nums[p2];
                p1++;
            }
        }
        return p1;
    }
}
