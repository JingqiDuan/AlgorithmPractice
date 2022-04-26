class Solution {
    //随便画一个具有极大值的连续函数，然后想想极大值和单调性的关系
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] < nums[mid + 1]){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return left;
    }
}

/*
class Solution {
    public int findPeakElement(int[] nums) {
        int index = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > nums[index]){
                index = i;
            }
        }
        return index;
    }
}
*/
