class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLen = nums1.length + nums2.length;
        if(totalLen % 2 == 0){
            return ((double) findKth(nums1, 0, nums2, 0, totalLen / 2) + 
                    (double) findKth(nums1, 0, nums2, 0, totalLen / 2 + 1)) / 2;
        }
        return findKth(nums1, 0, nums2, 0, (totalLen + 1) / 2);
    }

    private int findKth(int[] nums1, int left1, int[] nums2, int left2, int k){
        if(left1 >= nums1.length){
            return nums2[left2 + k - 1];
        }
        if(left2 >= nums2.length){
            return nums1[left1 + k - 1];
        }
        if(k == 1){
            return Math.min(nums1[left1], nums2[left2]);
        }
        //if one of the arr doesn't have enought elements, delete from the other arr
        int mid1 = left1 + k / 2 - 1 < nums1.length ? nums1[left1 + k / 2 - 1] : Integer.MAX_VALUE;
        int mid2 = left2 + k / 2 - 1 < nums2.length ? nums2[left2 + k / 2 - 1] : Integer.MAX_VALUE;
        if(mid1 >= mid2){
            return findKth(nums1, left1, nums2, left2 + k / 2, k - k / 2);
        }
        return findKth(nums1, left1 + k / 2, nums2, left2, k - k / 2);
    }
}
