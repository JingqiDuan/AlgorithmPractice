class Solution {
    public int triangleNumber(int[] nums) {
        if(nums == null){
            return 0;
        }
        Arrays.sort(nums);
        int answer = 0;
        int left = 0, right = nums.length - 1;
        for(int i = 1; i < nums.length; i++){//i is the longest edge
            left = 0;
            right = i - 1;
            while(left < right){
                if(nums[left] + nums[right] > nums[i]){
                    answer += (right - left);
                    right--;
                }else{
                    left++;
                }
            }
        }
        return answer;
    }

}
