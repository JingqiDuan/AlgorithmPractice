class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        if(nums1.length == 0 || nums2.length == 0){
            return 0;
        }
        int len1 = nums1.length;
        int len2 = nums2.length;
        int result = 0;
        int[][] dp = new int[len1 + 1][len2 + 1];
        for(int i = 1; i < len1 + 1; i++){
            for(int j = 1; j < len2 + 1; j++){
                dp[i][j] = nums1[i - 1] == nums2[j - 1] ? dp[i - 1][j - 1] + 1 : 0;
                result = Math.max(result, dp[i][j]);
            }
        }
        return result;
    }
}
