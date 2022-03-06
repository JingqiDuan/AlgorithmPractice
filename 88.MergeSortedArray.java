class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; ++i) {
            nums1[m + i] = nums2[i];
        }
        quickSort(nums1, 0, m + n - 1);
    }

    private void quickSort(int[] num, int start, int end){
        if(start >= end){
            return;
        }
        int left = start, right = end;
        int pivot = num[(right + left)/2];
        while(left <= right){
            while(left <= right && num[left] < pivot){
                left++;
            }
            while(left <= right && num[right] > pivot){
                right--;
            }
            if(left <= right){
                int tmp = num[left];
                num[left] = num[right];
                num[right] = tmp;
                left++;
                right--;
            }
        }
        quickSort(num, start, right);
        quickSort(num, left, end);
    }
}
