class Solution {
    public int findDuplicate(int[] nums) {
        //inter get in range [1,n] one is duplicated, so n + 1 elements
        //let's have a list of sequential number from 1 to n
        //try to search on our sequential number, find which one is the duplicated one in given array
        //by comparing with elems in arr, if between 1 and this number has number + 1 elements smaller
        //so the range is on left side of this number
        int left = 1, right = nums.length -1;
        while(left < right){
            int mid = left + (right - left) / 2;
            int cnt = 0;
            for(int num : nums){
                if(num <= mid){
                    cnt ++;
                }
            }
            if(cnt > mid){
                //move left
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
}
