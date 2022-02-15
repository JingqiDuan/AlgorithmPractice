class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return new int[]{-1, -1};
        }
         int firstPosition = findFirstPosition(nums, target);
         if(firstPosition == -1){
             return new int[]{-1, -1};
         }
         int lastPosition = findLastPosition(nums, target);
         return new int[]{firstPosition, lastPosition};
    }
    private int findFirstPosition(int[] nums, int target){
        int left = 0, right = nums.length -1;
        while(left < right){
            int mid = left + (right - left)/2;
            if(nums[mid] < target){
                left = mid + 1;
            }else if(nums[mid] == target){
                right = mid;
            }else{
                right = mid -1;
            }
        }
        if(nums[left] == target){
            return left;
        }else{
            return -1;
        }
    }
    private int findLastPosition(int[] nums, int target){
        int left = 0, right = nums.length -1;
        while(left < right){
            //round up when calculate the mid for lastPosition
            int mid = left + (right - left +1)/2;
            if(nums[mid] < target){
                left = mid + 1;
            }else if(nums[mid] == target){
                left = mid;
            }else{
                right = mid -1;
            }
        }
        return right;
    }
}
