class Solution {
    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int index = 0;
        int tmp;
        while(index <= right){
            if(nums[index] == 0){
                tmp = nums[left];
                nums[left] = nums[index];
                nums[index] = tmp;
                index++;
                left++;
            }else if(nums[index] == 2){
                tmp = nums[right];
                nums[right] = nums[index];
                nums[index] = tmp;
                right--;
            }else{
                index++;
            }
        }
    }
}
