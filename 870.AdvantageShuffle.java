class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int len = nums1.length;
        Integer[] indecies = new Integer[len];
        for(int i = 0; i < len; i++){
            indecies[i] = i;
        }
        Arrays.sort(indecies, (a, b) -> nums2[a] - nums2[b]);
        Arrays.sort(nums1);
        int[] results = new int[len];
        int left = 0, right = len - 1;
        for(int num : nums1){
            int index = num > nums2[indecies[left]] ?  indecies[left++] : indecies[right--];
            results[index] = num;
        }
        return results;
    }
}
