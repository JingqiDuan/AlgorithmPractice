class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int[] tmp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1, tmp);
        return nums[nums.length - k];
    }
    private void mergeSort(int[] nums, int start, int end, int[] tmp){
        if(start >= end){
            return;
        }
        mergeSort(nums, start, (start + end) / 2, tmp);
        mergeSort(nums, (start + end) / 2 + 1, end, tmp);
        merge(nums, start, end, tmp);
    }

    private void merge(int[] nums, int start, int end, int[] tmp){
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
