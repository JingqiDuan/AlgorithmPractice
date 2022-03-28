class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k == 0){
            return new int[0];
        }
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        for(int i = 0; i < k; i++){
            if(deque.isEmpty()){
                deque.offerLast(nums[i]);
            }else{
                while(!deque.isEmpty() && deque.peekLast() < nums[i]){
                    deque.pollLast();
                }
                deque.offerLast(nums[i]);
            }
        }
        result[0] = deque.peekFirst();
        for(int i = k; i < nums.length; i++){
            //attention here
            if(nums[i - k] == deque.peekFirst()){
                deque.pollFirst();
            }
            if(deque.isEmpty()){
                deque.offerFirst(nums[i]);
            }else{
                while(!deque.isEmpty() && deque.peekLast() < nums[i]){
                    deque.pollLast();
                }
                deque.offerLast(nums[i]);
            }
            result[i - k + 1] = deque.peekFirst();
        }
        return result;
    }
}
