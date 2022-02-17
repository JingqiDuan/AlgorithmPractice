class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while(left < right){
            int mid = left + (right - left) / 2;
            //list all possible combinations of position of three points
            //direction of moving left or right border defines the conditon
            if(nums[right] < nums[mid]){
                //move left border right
                left = mid + 1;
            }else{
                //move right border left 
                right = mid;
            }
        }
        return nums[left];
    }
}
