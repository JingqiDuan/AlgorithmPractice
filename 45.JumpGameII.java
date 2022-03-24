class Solution {
    public int jump(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int position = nums.length - 1;
        int step = 0;
        while(position > 0){
            for(int i = 0; i < nums.length; i++){
                if(nums[i] + i >= position){
                    position = i;
                    step++;
                    break;
                }
            }
        }
        return step;
    }
}
