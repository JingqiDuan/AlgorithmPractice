class Solution {
    public List<Integer> goodIndices(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        int len = nums.length;
        if(k > (len - 1) / 2) return result;
        int[] left = new int[len];
        int[] right = new int[len];
        for(int i = 1; i < len; i++){
            if(nums[i] <= nums[i - 1]){
                left[i] = left[i - 1] + 1;
            }else{
                left[i] = 0;
            }
        }
        
        for(int i = len - 2; i >= 0; i--){
            if(nums[i] <= nums[i + 1]){
                right[i] = right[i + 1] + 1;
            }else{
                right[i] = 0;
            }  
        }
        
        for(int i = k; i < len - k; i++){
            //The k elements that are just before the index i -> i - 1, i + 1
            if(left[i - 1] >= k - 1 && right[i + 1] >= k - 1) result.add(i);
        }
        return result;
    }
}
