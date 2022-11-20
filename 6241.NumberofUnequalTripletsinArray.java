class Solution {
    public int unequalTriplets(int[] nums) {
        //the difference -> sequence doesn't matter -> can sort
        Arrays.sort(nums);
        int result = 0, start = 0;
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] != nums[i + 1]){
                //i.e. 112233
                result += start * (i - start + 1) * (nums.length - 1 - i);
                start = i + 1;
            }
        }
        return result;
    }
}
