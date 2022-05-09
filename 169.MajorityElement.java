class Solution {
    public int majorityElement(int[] nums) {
        int vote = 0;
        int candidate = nums[0];
        for(int n : nums){  
            if(vote == 0){
                candidate = n;
            }          
            if(candidate == n){
                vote++;
            }else{
                vote--;
            }
        }
        return candidate;
    }
}
