class Solution {
    public int[] sortArray(int[] nums) {
        int[] tmp = new int[nums.length];
        mergeSort(nums, tmp, 0, nums.length - 1);
        return nums;
    }
    public void mergeSort(int[] nums, int[] tmp, int start, int end){
        if(start >= end){
            return;
        }
        mergeSort(nums, tmp, start, (start + end) / 2);
        mergeSort(nums, tmp, (start + end) / 2 + 1, end);
        merge(nums, tmp, start, end);
    }
    public void merge(int[] nums, int[] tmp, int start, int end){
        int left = start;
        int mid = (start + end) / 2;
        int right = mid + 1;
        int index = left;
        while(left <= mid && right <= end){
            if(nums[left] <= nums[right]){
                tmp[index++] = nums[left++];
            }else{
                tmp[index++] = nums[right++];
            }
        }
        while(left <= mid){
            tmp[index++] = nums[left++];
        }
        while(right <= end){
            tmp[index++] = nums[right++];
        }
        for(int i = start; i <= end; i++){
            nums[i] = tmp[i];
        }
    }
}
