/*class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 0 || nums == null){
            return -1;
        }
        int left = 0, right = nums.length -1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[left] < nums[mid]){ // left ordering
                if(target < nums[mid] && nums[left] <= target){//search in left part
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }else{ //right ordering
            //when element number is 2 and not inorder
                if(nums[right] ==  target){
                    return right;
                }
                if(nums[mid] < target && target <= nums[right]){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}*/

class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 0 || nums == null){
            return -1;
        }
        int left = 0, right = nums.length - 1;
        while(nums[right] < nums[left]){
            if(nums[right] == target){
                return right;
            }
            right --;
        }
      //note here, left + 1
        while(left + 1 < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] < target){
                left = mid;
            }else if(nums[mid] == target){
                return mid;
            }else{
                right = mid;
            }
        }
        if(nums[left] == target){
            return left;
        }
        if(nums[right] == target){
            return right;
        }
        return -1;
    }
}
