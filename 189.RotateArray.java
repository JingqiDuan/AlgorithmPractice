class Solution {
    /*
    nums = "----->-->"; k =3
    result = "-->----->";

    reverse "----->-->" we can get "<--<-----"
    reverse "<--" we can get "--><-----"
    reverse "<-----" we can get "-->----->"
     */
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        if(len <= 1){
            return;
        }
        int kIndex = k % len;
        reverse(nums, 0, len - 1);
        reverse(nums, 0, kIndex - 1);
        reverse(nums, kIndex, len - 1);
    }
    public void reverse(int[] nums, int start, int end){
        while(start < end){
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }
}
