class Solution {
    public boolean search(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return false;
        }
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            //mid is the key for defferent conditions
            if(nums[mid] == target){
                return true;
            }
            if(nums[left] == nums[mid]){
                left ++;
                continue;
            }
            //the left of mid is ordering
            if(nums[left] < nums[mid]){
                //target in the left of mid (left border included)
                if(nums[left] <= target && target < nums[mid]){
                    right = mid - 1;
                }else{
                    //go to the right side of mid
                    left = mid + 1; 
                }
            }else{//right of mid is ordering
                //target in the right  (right border included)
                if(nums[mid] < target && target <= nums[right]){
                    left = mid + 1;
                }else{//otherwise search on the left
                    right = mid - 1;
                }
            }
            
        }
        return false;
    }
}
